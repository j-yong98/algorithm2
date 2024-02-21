#include<bits/stdc++.h>
using namespace std;

#define SIZE 5

class Node {
public:
    int u, v, w;
    Node() {} // 기본 생성자 추가
    Node(int u, int v, int w) : u(u), v(v), w(w) {}
};

class Temp {
public:
    vector<int> order;
    Temp(vector<int>& order) : order(order) {}
    bool operator==(const Temp& other) const { return order == other.order; }
};

namespace std {
    template<>
    struct hash<Temp> {
        size_t operator()(const Temp& t) const {
            return hash<int>()(accumulate(t.order.begin(), t.order.end(), 0));
        }
    };
}

vector<vector<Node>> edges(SIZE);
unordered_map<Temp, vector<Node>> calc;
vector<int> parent, perm(SIZE);
int N, M, Q;

int findParent(int a) {
    if (a == parent[a]) return a;
    return parent[a] = findParent(parent[a]);
}

void unionParent(int a, int b) {
    int p1 = findParent(a);
    int p2 = findParent(b);
    if (p1 != p2) parent[p2] = p1;
}

bool next_permutation() {
    int i = SIZE - 1;
    while (i > 0 && perm[i - 1] >= perm[i]) i--;
    if (i == 0) return false;
    int j = SIZE - 1;
    while (perm[i - 1] >= perm[j]) j--;
    swap(perm[i - 1], perm[j]);
    int k = SIZE - 1;
    while (i < k) swap(perm[i++], perm[k--]);
    return true;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N >> M >> Q;
    parent.resize(N + 1);
    for (int i = 0; i < SIZE; i++) perm[i] = i;
    for (int i = 0; i < M; i++) {
        int u, v;
        char c;
        cin >> u >> v >> c;
        edges[c - 'A'].push_back(Node(u, v, c - 'A'));
    }

    do {
        for (int i = 1; i <= N; i++) parent[i] = i;
        vector<Node> c(N - 1);
        int idx = 0;
        for (int i = 0; i < SIZE; i++) {
            for (Node& edge : edges[perm[i]]) {
                if (findParent(edge.u) != findParent(edge.v)) {
                    unionParent(edge.u, edge.v);
                    c[idx++] = edge;
                }
            }
        }
        calc[Temp(perm)] = c;
    } while (next_permutation());

    vector<int> order(SIZE), val(SIZE);
    for (int i = 0; i < SIZE; i++) order[i] = i;
    for (int i = 0; i < Q; i++) {
        long long ans = 0;
        for (int j = 0; j < SIZE; j++) cin >> val[j];
        sort(order.begin(), order.end(), [&](int a, int b) { return val[a] < val[b]; });

        vector<Node>& nodes = calc[Temp(order)];
        for (Node& node : nodes) ans += val[node.w];
        cout << ans << "\n";
    }

    return 0;
}
