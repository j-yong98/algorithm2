import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 1_000_000_001;
    static int N, M;
    static int[] arr;
    static int[][] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        tree = new int[4 * N + 1][];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        init(1, 0, N - 1);
        for (int i = 1; i < 4 * N; i++) {
            if (tree[i] == null) {
                continue;
            }
            Arrays.sort(tree[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()) - 1;
            int r = Integer.parseInt(st.nextToken()) - 1;
            int k = Integer.parseInt(st.nextToken());
            int left = -MAX;
            int right = MAX;
            while (left <= right) {
                int mid = (left + right) >> 1;

                if (query(1, 0, N - 1, l, r, mid) < k) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            sb.append(right).append("\n");
        }
        System.out.print(sb);
    }

    private static int query(int node, int s, int e, int l, int r, int k) {
        if (s > r || e < l) return 0;

        if (s >= l && r >= e) {
            return lower(tree[node], k);
        }

        int mid = (s + e) >> 1;
        int a = query(node * 2, s, mid, l, r, k);
        int b = query(node * 2 + 1, mid + 1, e, l, r, k);
        return a + b;
    }

    private static int lower(int[] arr, int k) {
        int l = 0;
        int r = arr.length;

        while (l < r) {
            int mid = (l + r) >> 1;

            if (arr[mid] < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }

    private static int[] init(int node, int s, int e) {
        if (s == e) {
            return tree[node] = new int[]{arr[s]};
        }

        int mid = (s + e) >> 1;
        int[] a = init(node * 2, s, mid);
        int[] b = init(node * 2 + 1, mid + 1, e);
        return tree[node] = merge(a, b);
    }

    private static int[] merge(int[] a, int[] b) {
        int len = a.length + b.length;
        int[] ret = new int[len];

        int aLen = a.length;
        for (int i = 0; i < aLen; i++) {
            ret[i] = a[i];
        }

        int bLen = b.length;
        for (int i = 0; i < bLen; i++) {
            ret[i + aLen] = b[i];
        }

        return ret;
    }
}

