import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Map<String, Integer> map = new HashMap<>();
    static int[] from;
    static int[] tree;
    /**
     * 빌보의 생일
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            from = new int[N];
            tree = new int[4 * N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                map.put(st.nextToken(), i);
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                String name = st.nextToken();
                from[i] = map.get(name);
            }
            long ans = 0;
            for (int i = 0; i < N; i++) {
                ans += query(1, 0, N - 1, from[i] + 1, N - 1);
                update(1, 0, N - 1, from[i]);
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    private static int query(int node, int s, int e, int l, int r) {
        if (s > r || e < l) {
            return 0;
        }

        if (l <= s && e <= r) {
            return tree[node];
        }

        int mid = (s + e) >> 1;
        int a = query(node * 2, s, mid, l, r);
        int b = query(node * 2 + 1, mid + 1, e, l, r);
        return a + b;
    }

    private static void update(int node, int s, int e, int k) {
        if (s > k || e < k) return;

        tree[node] += 1;
        if (s == e) {
            return;
        }

        int mid = (s + e) >> 1;
        update(node * 2, s, mid, k);
        update(node * 2 + 1, mid + 1, e, k);
    }
}