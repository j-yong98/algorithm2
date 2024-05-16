import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 100;
    static int N;
    static int A, B;
    static int[][] arr = new int[MAX + 1][4];
    static int[][][][] dp = new int[MAX + 1][MAX + 1][MAX + 1][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                for (int k = 0; k <= N; k++) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }
        System.out.println(f(0, 0, 0, 0));
    }

    private static int f(int n, int a, int b, int prev) {
        if (n == N) {
            if (b < B) {
                return Integer.MIN_VALUE;
            }
            return 0;
        }

        if (dp[n][a][b][prev] != -1) {
            return dp[n][a][b][prev];
        }

        // 정독실, 소학습실
        dp[n][a][b][prev] = f(n + 1, a, b + 1, 0) + Math.max(arr[n][0], arr[n][1]);
        if (a + 1 <= A) { // 방으로 요양
            dp[n][a][b][prev] = Math.max(dp[n][a][b][prev], f(n + 1, a + 1, b, 0) + arr[n][3]);
        }
        if (prev == 0) { // 전날 휴게실을 사용 안했다면
            dp[n][a][b][prev] = Math.max(dp[n][a][b][prev], f(n + 1, a, b, 1) + arr[n][2]);
        }
        return dp[n][a][b][prev];
    }
}