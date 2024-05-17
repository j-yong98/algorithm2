import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 500;
    static int[] b = new int[3];
    static int[] k = new int[2];
    static int[][] dp = new int[MAX + 1][MAX + 1];

    /**
     * 구슬 게임
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i <= MAX; i++) {
            Arrays.fill(dp[i], -1);
        }
        StringBuilder sb = new StringBuilder();
        for (int T = 0; T < 5; T++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 2; i++) {
                k[i] = Integer.parseInt(st.nextToken());
            }
            sb.append(f(k[0], k[1]) == 1 ? 'A' : 'B').append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static int f(int k1, int k2) {
        if (dp[k1][k2] != -1) {
            return dp[k1][k2];
        }

        dp[k1][k2] = 0;
        for (int i = 2; i >= 0; i--) {
            if (k1 - b[i] >= 0) {
                int res = f(Math.max(0, k1 - b[i]), k2);
                if (res == 0) {
                    return dp[k1][k2] = 1;
                }
            }
            if (k2 - b[i] >= 0) {
                int res = f(k1, Math.max(0, k2 - b[i]));
                if (res == 0) {
                    return dp[k1][k2] = 1;
                }
            }
        }
        return dp[k1][k2];
    }
}