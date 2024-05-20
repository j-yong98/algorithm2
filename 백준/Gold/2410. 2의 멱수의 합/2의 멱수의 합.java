import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static final int MOD = 1_000_000_000;
    static int N;
    static int M;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; (1 << i) <= N; i++) {
            M++;
        }
        dp = new int[M + 1][N + 1];
        for (int i = 0; i <= M; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(f(N, M));
    }

    private static int f(int n, int prev) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (dp[prev][n] != -1) {
            return dp[prev][n];
        }

        dp[prev][n] = 0;
        for (int i = prev; i >= 0; i--) {
            dp[prev][n] = (dp[prev][n] + f(n - (1 << i), i)) % MOD;
        }
        return dp[prev][n];
    }
}