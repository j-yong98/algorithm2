import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr = {1, 3, 5};
    static double[] a = {1.05, 1.2, 1.35};
    static int H, Y;
    static int[] dp;
    /**
     *  투자의 귀재 배주형
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        dp = new int[Y + 1];
        dp[0] = H;
        for (int i = 1; i <= Y; i++) {
            for (int j = 0; j < 3; j++) {
                if (i - arr[j] < 0) continue;
                dp[i] = Math.max(dp[i], (int) ((double) dp[i - arr[j]] * a[j]));
            }
        }
        System.out.println(dp[Y]);
        br.close();
    }

}