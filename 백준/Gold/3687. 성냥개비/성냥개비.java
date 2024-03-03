import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int T;
    static int N;
    static long[] dp = new long[105];
    static int[] digit = {0, 0, 1, 7, 4, 2, 0, 8, 10};

    /**
     * 성냥개비
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 1; i <= 8; i++) {
            dp[i] = digit[i];
        }
        dp[6] = 6;
        for (int i = 9; i <= 100; i++) {
            dp[i] = dp[i - 2] * 10 + digit[2];
            for (int j = 3; j < 8; j++) {
                dp[i] = Math.min(dp[i], dp[i - j] * 10 + digit[j]);
            }
        }
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            StringBuilder tmp = new StringBuilder();
            sb.append(dp[N]).append(" ");
            getMaxNum(N, tmp);
            sb.append(tmp.reverse()).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static void getMaxNum(int cnt, StringBuilder sb) {
        if (cnt == 0) {
            return;
        }

        if (cnt == 3) {
            sb.append(7);
            return;
        }

        sb.append(1);
        getMaxNum(cnt - 2, sb);
    }
}