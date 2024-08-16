import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MAX = 1_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] dp = new long[MAX + 1];
        for (int i = 1; i <= MAX; i++) {
            for (int j = 1; (long) i * j <= MAX; j++) {
                dp[i * j] += i;
            }
        }
        for (int i = 1; i <= MAX; i++) {
            dp[i] += dp[i - 1];
        }
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append("\n");
        }
        System.out.println(sb);
    }

}