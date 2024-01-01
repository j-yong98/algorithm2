import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int MOD = 1_000_000_000;
    static int N, K;
    static int[][] dp;
    /**
     * 합분해
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][K + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 0; i <= N; i++) {
            dp[i][1] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                for (int k = 0; k <= i; k++) {
                    dp[i][j] += dp[k][j - 1];
                    dp[i][j] %= MOD;
                }
            }
        }
        System.out.println(dp[N][K]);
        br.close();
    }
}