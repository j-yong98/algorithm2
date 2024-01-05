#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int n, m;
vector<int> list[10001];
int cnt[10001];

void bfs(int start) {
    bool visited[10001] = { false };
    queue<int> q;

    q.push(start);
    visited[start] = true;

    while (!q.empty()) {
        int now = q.front();
        q.pop();
        for (int next : list[now]) {
            if (visited[next]) continue;
            visited[next] = true;
            q.push(next);
            cnt[next]++;
        }
    }
}

int main() {
    cin >> n >> m;
    for (int i = 0; i < m; i++) {
        int a, b;
        cin >> a >> b;
        list[a].push_back(b);
    }

    for (int i = 1; i <= n; i++)
        bfs(i);
    int m = 0;
    for (int i = 1; i <= n; i++) {
        m = max(cnt[i], m);
    }
    for (int i = 1; i <= n; i++) {
        if (m == cnt[i])
            cout << i << " ";
    }
    cout << "\n";

    return 0;
}
