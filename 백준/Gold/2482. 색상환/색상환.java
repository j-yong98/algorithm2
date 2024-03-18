import java.io.*;

public class Main {
    static final int MOD = 1_000_000_003;
    static int n, k;
    static int[][] dp;
    /**
     * 색상환
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++)
            dp[i][1] = i;
        for (int i = 4; i <= n; i++) {
            for (int j = 2; j <= k; j++)
                dp[i][j] = (dp[i - 2][j - 1] + dp[i - 1][j]) % MOD;
        }
        bw.write(dp[n][k] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
