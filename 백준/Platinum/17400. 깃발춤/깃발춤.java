import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, Q;
    static int[] arr;
    static long[] oddTree;
    static long[] evenTree;

    /**
     * 깃발춤
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        oddTree = new long[4 * N];
        evenTree = new long[4 * N];
        init(1, 1, N, oddTree, false);
        init(1, 1, N, evenTree, true);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                long v1 = query(1, 1, N, a, b, oddTree);
                long v2 = query(1, 1, N, a, b, evenTree);
                sb.append(Math.abs(v1 - v2)).append("\n");
            } else {
                if (a % 2 == 0) {
                    update(1, 1, N, a, b, evenTree);
                } else {
                    update(1, 1, N, a, b, oddTree);
                }
                arr[a] += b;
            }
        }
        System.out.print(sb);
        br.close();
    }

    private static long query(int node, int s, int e, int l, int r, long[] tree) {
        if (s > r || e < l) {
            return 0;
        }

        if (s >= l && r >= e) {
            return tree[node];
        }

        int mid = (s + e) >> 1;
        long a = query(node * 2, s, mid, l, r, tree);
        long b = query(node * 2 + 1, mid + 1, e, l, r, tree);
        return a + b;
    }

    private static void update(int node, int s, int e, int k, int v, long[] tree) {
        if (s > k || e < k) return;

        tree[node] += v;
        if (s == e) return;

        int mid = (s + e) >> 1;
        update(node * 2, s, mid, k, v, tree);
        update(node * 2 + 1, mid + 1, e, k, v, tree);
    }

    private static long init(int node, int l, int r, long[] tree, boolean flag) {
        if (l == r) {
            if (flag) {
                if (l % 2 == 0) {
                    tree[node] = arr[l];
                }
                return tree[node];
            } else {
                if (l % 2 == 1) {
                    tree[node] = arr[l];
                }
                return tree[node];
            }
        }

        int mid = (l + r) >> 1;
        long a = init(node * 2, l, mid, tree, flag);
        long b = init(node * 2 + 1, mid + 1, r, tree, flag);
        return tree[node] = a + b;
    }
}