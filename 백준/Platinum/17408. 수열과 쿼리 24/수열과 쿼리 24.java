import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, Q;
    static int[] arr;
    static Node[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        tree = new Node[4 * N];
        tree[0] = new Node(0, 0);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int v = Integer.parseInt(st.nextToken());
            arr[i] = v;
        }
        init(1, 0, N - 1);
        Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                update(1, 0, N - 1, a - 1, b);
                arr[a - 1] = b;
            } else {
                Node query = query(1, 0, N - 1, a - 1, b - 1);
                sb.append(query.first + query.second).append("\n");
            }
        }
        System.out.print(sb);
    }

    private static Node query(int cur, int s, int e, int l, int r) {
        if (s > r || e < l) return tree[0];

        if (s >= l && r >= e) {
            return tree[cur];
        }

        int mid = (s + e) >> 1;
        Node a = query(cur * 2, s, mid, l, r);
        Node b = query(cur * 2 + 1, mid + 1, e, l, r);
        return merge(a, b);
    }

    private static void update(int cur, int s, int e, int idx, int val) {
        if (s > idx || e < idx) return;

        if (s == e) {
            tree[cur].first = val;
            tree[cur].second = 0;
            return;
        }
        int mid = (s + e) >> 1;
        update(cur * 2, s, mid, idx, val);
        update(cur * 2 + 1, mid + 1, e, idx, val);
        tree[cur] = merge(tree[cur * 2], tree[cur * 2 + 1]);
    }

    private static Node init(int cur, int s, int e) {
        if (s == e) {
            return tree[cur] = new Node(arr[s], 0);
        }

        int mid = (s + e) >> 1;
        Node a = init(cur * 2, s, mid);
        Node b = init(cur * 2 + 1,mid + 1, e);
        return tree[cur] = merge(a, b);
    }

    private static Node merge(Node a, Node b) {
        int first = Math.max(a.first, b.first);
        int second;
        if (a.first > b.first) {
            second = Math.max(a.second, b.first);
        } else {
            second = Math.max(a.first, b.second);
        }
        return new Node(first, second);
    }

    static class Node {
        int first;
        int second;

        public Node(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}

