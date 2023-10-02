import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    final static int MOD = 1_000_000_007;
    static int N;
    static int[] arr;
    static int M;
    static long[] tree;
    static long[][] lazy;

    /**
     * 수열과 쿼리 13
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        tree = new long[4 * N];
        lazy = new long[4 * N][2];
        for (int i = 0; i < 4 * N; i++)
            lazy[i][0] = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        init(1, 0, N - 1);
        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken()) - 1;
            int r = Integer.parseInt(st.nextToken()) - 1;
            if (cmd == 1) {
                int val = Integer.parseInt(st.nextToken());
                update(1, 0, N - 1, l, r, 1, val);
            } else if (cmd == 2) {
                int val = Integer.parseInt(st.nextToken());
                update(1, 0, N - 1, l, r, val, 0);
            } else if (cmd == 3) {
                int val = Integer.parseInt(st.nextToken());
                update(1, 0, N - 1, l, r, 0, val);
            } else
                sb.append(query(1, 0, N - 1, l, r)).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    private static void update(int node, int s, int e, int l, int r, int mul, int add) {
        updateLazy(node, s, e);
        if (s > r || e < l) return;

        if (s >= l && r >= e) {
            lazy[node][0] = (lazy[node][0] * mul) % MOD;
            lazy[node][1] = (lazy[node][1] * mul + add) % MOD;
            updateLazy(node, s, e);
            return;
        }

        int mid = (s + e) >> 1;
        update(node * 2, s, mid, l, r, mul, add);
        update(node * 2 + 1, mid + 1, e, l, r, mul, add);
        tree[node] = (tree[node * 2] + tree[node * 2 + 1]) % MOD;
    }

    private static void updateLazy(int node, int s, int e) {
        if (lazy[node][0] == 1 && lazy[node][1] == 0) return;
        tree[node] = ((tree[node] * lazy[node][0]) + (lazy[node][1] * (e - s + 1))) % MOD;
        if (s != e) {
            lazy[node * 2][0] = (lazy[node][0] * lazy[node * 2][0]) % MOD;
            lazy[node * 2][1] = (lazy[node][0] * lazy[node * 2][1] + lazy[node][1]) % MOD;
            lazy[node * 2 + 1][0] = (lazy[node][0] * lazy[node * 2 + 1][0]) % MOD;
            lazy[node * 2 + 1][1] = (lazy[node][0] * lazy[node * 2 + 1][1] + lazy[node][1]) % MOD;
        }
        lazy[node][0] = 1;
        lazy[node][1] = 0;
    }

    private static long query(int node, int s, int e, int l, int r) {
        updateLazy(node, s, e);
        if (s > r || e < l) return 0;

        if (s >= l && r >= e) return tree[node];

        int mid = (s + e) >> 1;
        long a = query(node * 2, s, mid, l, r);
        long b = query(node * 2 + 1, mid + 1, e, l, r);
        return (a + b) % MOD;
    }

    private static long init(int node, int s, int e) {
        if (s == e) return tree[node] = arr[s];

        int mid = (s + e) >> 1;
        long a = init(node * 2, s, mid);
        long b = init(node * 2 + 1, mid + 1, e);
        return tree[node] = (a + b) % MOD;
    }
}