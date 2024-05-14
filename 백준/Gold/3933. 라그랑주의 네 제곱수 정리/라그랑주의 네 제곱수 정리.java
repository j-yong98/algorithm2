import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static final int MAX = (1 << 15);
    static int N;
    static int[][][] dp = new int[4][MAX + 1][(int) Math.sqrt(MAX) + 1];

    /**
     * 라그랑주의 네 제곱수 정리
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        for (int k = 0; k < 4; k++) {
            for (int i = 0; i <= MAX; i++) {
                Arrays.fill(dp[k][i], -1);
            }
        }
        while ((line = br.readLine()) != null) {
            N = Integer.parseInt(line);
            if (N == 0) {
                break;
            }
            sb.append(f(0, 1, N)).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    /**
     * 25 -> 1, 4, 4, 16 3, 4 5
     */
    private static int f(int cnt, int prev, int sum) {
        if (sum == 0) {
            return 1;
        }
        if (cnt == 4 || sum < 0) {
            return 0;
        }

        if (dp[cnt][sum][prev] != -1) {
            return dp[cnt][sum][prev];
        }

        dp[cnt][sum][prev] = 0;
        for (int i = prev; i <= Math.sqrt(N); i++) {
            dp[cnt][sum][prev] += f(cnt + 1, i, sum - i * i);
        }
        return dp[cnt][sum][prev];
    }
}