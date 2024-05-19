import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[][][] dp;
    static int MOD = 1_000_000_000;

    /**
     * 계단 수
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][10][1 << 10];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        long ans = 0;
        for (int i = 1; i <= 9; i++) {
            ans = (ans + f(N, i, (1 << i))) % MOD;
        }
        System.out.println(ans);
        br.close();
    }

    private static int f(int n, int prev, int visited) {
        if (n == 1) {
            if (visited == (1 << 10) - 1) {
                return 1;
            }
            return 0;
        }

        if (dp[n][prev][visited] != -1) {
            return dp[n][prev][visited];
        }

        dp[n][prev][visited] = 0;
        if (prev - 1 >= 0) {
            dp[n][prev][visited] = (dp[n][prev][visited] + f(n - 1, prev - 1, visited | (1 << (prev - 1)))) % MOD;
        }
        if (prev + 1 <= 9) {
            dp[n][prev][visited] = (dp[n][prev][visited] + f(n - 1, prev + 1, visited | (1 << (prev + 1)))) % MOD;
        }
        return dp[n][prev][visited];
    }

}