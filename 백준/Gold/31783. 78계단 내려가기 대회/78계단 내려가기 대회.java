import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr = new int[3][];
    static long[] dp;
    /**
     * 78계단 내려가기 대회
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new long[N];
        for (int i = 0; i < 3; i++) {
            arr[i] = new int[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = i == 0 ? 0 : 1; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i < N; i++) {
            int l = 0;
            int r = i - 1;
            int idx = -1;
            while (l <= r) {
                int m = (l + r) >> 1;
                if (arr[0][m] >= arr[0][i] + arr[2][i]) {
                    idx = m;
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            if (idx == -1) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = Math.max(dp[idx] + arr[1][i], dp[i - 1]);
            }
        }
        System.out.println(dp[N - 1]);
        br.close();
    }

}