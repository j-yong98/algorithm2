import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int K;
    static int[] arr;
    static int[] sum;
    static int[][] dp;
    /**
     * 파일 합치기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            K = Integer.parseInt(br.readLine());
            arr = new int[K + 1];
            sum = new int[K + 1];
            dp = new int[K + 1][K + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= K; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + arr[i];
            }

            for (int i = 1; i <= K; i++) {
                for (int j = 1; j <= K - i; j++) {
                    dp[j][i + j] = Integer.MAX_VALUE;
                    for (int k = j; k < i + j; k++) {
                        dp[j][i + j] = Math.min(dp[j][i + j], dp[j][k] + dp[k + 1][i + j] + sum[i + j] - sum[j - 1]);
                    }
                }
            }

            System.out.println(dp[1][K]);
        }
        br.close();
    }
}