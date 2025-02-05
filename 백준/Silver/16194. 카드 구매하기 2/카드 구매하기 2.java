import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static int[] dp;
    /**
     * 문제이름
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, -1);
        System.out.println(f(0));
        br.close();
    }

    private static int f(int n) {
        if (n == N) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if (n + (i + 1) > N) {
                continue;
            }
            dp[n] = Math.min(dp[n], f(n + (i + 1)) + arr[i]);
        }
        return dp[n];
    }
}