import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 100;
    static int T;
    static int N, K;
    static int[][][] dp = new int[MAX + 5][MAX + 5][2];

    /**
     * 인접한 비트의 개수
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        dp[1][0][0] = 1;
        dp[1][0][1] = 1;

        for (int i = 2; i <= MAX; i++) {
            for (int j = 0; j < i; j++) {
                dp[i][j][0] = dp[i - 1][j][0] + dp[i - 1][j][1];
                if (j == 0) {
                    dp[i][j][1] = dp[i-1][j][0];
                } else {
                    dp[i][j][1] = dp[i-1][j][0] + dp[i-1][j-1][1];
                }
            }
        }
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            sb.append(dp[N][K][0] + dp[N][K][1]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static int f(int n, int k, int prev) {
        if (n == -1) {
            if (k == 0) {
                return 1;
            }
            return 0;
        }

        if (dp[n][k][prev] != -1) {
            return dp[n][k][prev];
        }

        dp[n][k][prev] = f(n - 1, k, 0);
        if (!(k == 0 && prev == 1)) {
            dp[n][k][prev] += f(n - 1, k - prev, 1);
        }
        return dp[n][k][prev];
    }
}