import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dp = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = arr[i];
        }

        int m = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[i] < arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
                m = Math.max(m, dp[i]);
            }
        }
        System.out.println(m);
    }
}