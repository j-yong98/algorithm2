import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        tree = new int[4 * N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        init(1, 0, N - 1);
        int[] ans = new int[3];
        int res = 0;
        ans[0] = query(1, 0, N - 1, 0, N - 2);
        for (int i = 1; i < N - 1; i++) {
            int tmp = query(1, 0, N - 1, 0, i - 1) - arr[i];
            res = Math.max(res, tmp);
        }
        ans[0] += res;

        res = 0;
        ans[1] = query(1, 0, N - 1, 1, N - 1);
        for (int i = 1; i < N - 1; i++) {
            int tmp = query(1, 0, N - 1, i + 1, N - 1) - arr[i];
            res = Math.max(res, tmp);
        }
        ans[1] += res;

        for (int i = 1; i < N - 1; i++) {
            int tmp = query(1, 0, N - 1, 1, i) + query(1, 0, N - 1, i, N - 2);
            ans[2] = Math.max(ans[2], tmp);
        }
        int max = 0;
        for (int i = 0; i < 3; i++) {
            max = Math.max(max, ans[i]);
        }
        System.out.println(max);
        br.close();
    }

    private static int init(int node, int s, int e) {
        if (s == e) {
            return tree[node] = arr[s];
        }

        int mid = (s + e) >> 1;
        int a = init(node * 2, s, mid);
        int b = init(node * 2 + 1, mid + 1, e);
        return tree[node] = a + b;
    }

    private static int query(int node, int s, int e, int l, int r) {
        if (s > r || e < l) {
            return 0;
        }

        if (s >= l && r >= e) {
            return tree[node];
        }

        int mid = (s + e) >> 1;
        int a = query(node * 2, s, mid, l, r);
        int b = query(node * 2 + 1, mid + 1, e, l, r);
        return a + b;
    }
}