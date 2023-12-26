import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dp;
    /**
     * 문제이름
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = 0;
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (i == 0) min = x;
            else {
                if (x < min) min = x;
                dp[i] = Math.max(dp[i - 1], x - min);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(dp[i]).append(" ");
        }
        System.out.print(sb);
        br.close();
    }
}