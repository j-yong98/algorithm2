import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static final int MOD = 1_000_000_007;
    static int N;
    static int[] dp;
    /**
     * 피보나치는 지겨웡
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        Arrays.fill(dp, -1);
        System.out.println(f(N));
        br.close();
    }

    private static int f(int n) {
        if (n < 0) {
            return 0;
        }

        if (n < 2) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = ((f(n - 2) + f(n - 1)) % MOD + 1) % MOD;
    }
}