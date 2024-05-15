import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static final int MOD = 1_000_000_007;
    static final int MAX = 1000;
    static int N;
    static int[][][][] dp = new int[MAX + 1][3][3][2];
    /**
     * 공룡게임
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }
        System.out.println(f(1, 0, 0, 0));
        br.close();
    }

    private static int f(int n, int prev, int next, int flag) {
        if (n == N) {
            return flag;
        }

        if (dp[n][prev][next][flag] != -1) {
            return dp[n][prev][next][flag];
        }

        dp[n][prev][next][flag] = 0;
        if (next == 0) {
            dp[n][prev][next][flag] = (dp[n][prev][next][flag] + f(n + 1, next, 0, flag)) % MOD;
            dp[n][prev][next][flag] = (dp[n][prev][next][flag] + f(n + 1, next, 1, flag)) % MOD;
            dp[n][prev][next][flag] = (dp[n][prev][next][flag] + f(n + 1, next, 2, 1)) % MOD;
        } else if (next == 1) {
            if (prev == 0) {
                dp[n][prev][next][flag] = (dp[n][prev][next][flag] + f(n + 1, next, 0, flag)) % MOD;
                dp[n][prev][next][flag] = (dp[n][prev][next][flag] + f(n + 1, next, 1, flag)) % MOD;
                dp[n][prev][next][flag] = (dp[n][prev][next][flag] + f(n + 1, next, 2, 1)) % MOD;
            } else {
                dp[n][prev][next][flag] = (dp[n][prev][next][flag] + f(n + 1, next, 0, flag)) % MOD;
            }
        } else if (next == 2) {
            if (prev == 0) {
                dp[n][prev][next][flag] = (dp[n][prev][next][flag] + f(n + 1, next, 0, flag)) % MOD;
                dp[n][prev][next][flag] = (dp[n][prev][next][flag] + f(n + 1, next, 1, flag)) % MOD;
            } else {
                dp[n][prev][next][flag] = (dp[n][prev][next][flag] + f(n + 1, next, 0, flag)) % MOD;
            }
        }
        return dp[n][prev][next][flag];
    }
}