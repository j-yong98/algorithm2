import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] open = new int[2];
    static int[] orders;
    static int ans = Integer.MAX_VALUE;

    /**
     * 벽장문의 이동
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int idx = 0;
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            open[idx++] = num;
        }
        M = Integer.parseInt(br.readLine());
        orders = new int[M];
        for (int i = 0; i < M; i++) {
            orders[i] = Integer.parseInt(br.readLine());
        }
        dfs(0, 0);
        System.out.println(ans);
        br.close();
    }

    private static void dfs(int depth, int cnt) {
        if (depth == M) {
            ans = Math.min(ans, cnt);
            return;
        }
        for (int i = 0; i < 2; i++) {
            int o = open[i];
            open[i] = orders[depth];
            dfs(depth + 1, cnt + getDist(orders[depth], o));
            open[i] = o;
        }
    }

    private static int getDist(int a, int b) {
        return Math.abs(a - b);
    }
}