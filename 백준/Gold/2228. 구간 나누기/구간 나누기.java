import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int MIN = -10_000_000;
    static int N, M;
    static int[] arr;
    static int[][] dp;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        dp = new int[N][M + 1];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], MIN);
        }
        System.out.println(f(N - 1, M));
    }

    private static int f(int n, int m) {
        if (m == 0) {
            return 0;
        }
        if (n <= -1) {
            return MIN * 2;
        }

        if (dp[n][m] != MIN) {
            return dp[n][m];
        }

        dp[n][m] = f(n - 1, m);

        int res = 0;
        for (int i = n; i >= 0; i--) {
            res += arr[i];
            dp[n][m] = Math.max(dp[n][m], f(i - 2, m - 1) + res);
        }

        return dp[n][m];
    }
}