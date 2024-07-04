import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, Q;
    static int[] arr;
    static Node[] tree;

    /**
     * 수열과 어렵지 않은 쿼리
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        tree = new Node[4 * N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        init(1, 1, N);
        StringBuilder sb = new StringBuilder();
        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                arr[l] = r;
                update(1, 1, N, l);
            } else {
                Node res = query(1, 1, N, l, r);
                if (res == null) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(res.cnt).append("\n");
                }
            }
        }
        System.out.print(sb);
        br.close();
    }

    private static Node init(int node, int s, int e) {
        if (s == e) {
            return tree[node] = new Node(arr[s], arr[e], 1);
        }

        int mid = (s + e) >> 1;
        Node a = init(node * 2, s, mid);
        Node b = init(node * 2 + 1, mid + 1, e);

        return tree[node] = merge(a, b);
    }

    private static Node merge(Node a, Node b) {
        if (a == null) {
            return new Node(b.l, b.r, b.cnt);
        } else if (b == null) {
            return new Node(a.l, a.r, a.cnt);
        }
        int cnt = a.r != b.l ? a.cnt + b.cnt : a.cnt + b.cnt - 1;
        return new Node(a.l, b.r, cnt);
    }

    private static Node update(int node, int s, int e, int k) {
        if (s > k || e < k) {
            return tree[node];
        }

        if (s == e) {
            return tree[node] = new Node(arr[s], arr[e], 1);
        }

        int mid = (s + e) >> 1;
        Node a = update(node * 2, s, mid, k);
        Node b = update(node * 2 + 1, mid + 1, e, k);
        return tree[node] = merge(a, b);
    }

    private static Node query(int node, int s, int e, int l, int r) {
        if (r < s || e < l) {
            return null;
        }

        if (l <= s && e <= r) {
            return tree[node];
        }

        int mid = (s + e) >> 1;
        Node a = query(node * 2, s, mid, l, r);
        Node b = query(node * 2 + 1, mid + 1, e, l, r);
        return merge(a, b);
    }

    static class Node {
        int l;
        int r;
        int cnt;

        public Node(int l, int r, int cnt) {
            this.l = l;
            this.r = r;
            this.cnt = cnt;
        }
    }
}