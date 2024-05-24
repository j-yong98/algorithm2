import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][3];
        dp = new int[N][3][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        for (int i = 0; i < 3; i++) {
            dp[0][i][i] = f(1, i, i) + arr[0][i];
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                if (dp[0][j][k] == -1) continue;
                ans = Math.min(ans, dp[0][j][k]);
            }
        }
        System.out.println(ans);
    }

    private static int f(int n, int prev, int start) {
        if (n == N) {
            return 0;
        }

        if (dp[n][prev][start] != -1) {
            return dp[n][prev][start];
        }

        dp[n][prev][start] = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (i == prev) continue;
            if (n == N - 1 && i == start) continue;
            dp[n][prev][start] = Math.min(dp[n][prev][start], f(n + 1, i, start) + arr[n][i]);
        }

        return dp[n][prev][start];
    }
}