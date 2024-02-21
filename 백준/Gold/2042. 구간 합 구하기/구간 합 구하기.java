import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 1_000_000;
    static int N, M, K;
    static long[] tree = new long[4 * MAX + 1];
    static long[] arr = new long[MAX];

    /**
     * 구간 합 구하기 
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++)
            arr[i] = Long.parseLong(br.readLine());
        init(1, 0, N - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if (a == 1) {
                int b = Integer.parseInt(st.nextToken()) - 1;
                long c = Long.parseLong(st.nextToken());
                long diff = c - arr[b];
                update(1, 0, N - 1, b, diff);
                arr[b] = c;
            } else if (a == 2) {
                int b = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken()) - 1;
                sb.append(query(1, b, c, 0, N - 1)).append("\n");
            }
        }
        System.out.print(sb);
    }

    private static long init(int node, int left, int right) {
        if (left == right) return tree[node] = arr[left];

        int mid = (left + right) / 2;
        return tree[node] = init(node * 2, left, mid) + init(node * 2 + 1, mid + 1, right);
    }

    private static void update(int node, int left, int right, int target, long diff) {
        if (target < left || target > right) return;


        tree[node] += diff;
        if (left == right) return;

        int mid = (left + right) / 2;
        update(node * 2, left, mid, target, diff);
        update(node * 2 + 1, mid + 1, right, target, diff);
    }

    private static long query(int node, int s, int e, int left, int right) {
        if (s > right || e < left) return 0;

        if (s <= left && right <= e) return tree[node];

        int mid = (left + right) / 2;
        return query(node * 2, s, e, left, mid) + query(node * 2 + 1, s, e, mid + 1, right);
    }
}
