import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 100_000;
    static int N, K;
    static boolean[] visited = new boolean[MAX + 1];
    static int[] dp;

    /**
     * 정수를 끝까지 외치자
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            visited[num] = true;
        }
        dp = new int[N + 1];
        Arrays.fill(dp, -1);
        System.out.println(f(0));
        br.close();
    }

    private static int f(int cur) {

        if (dp[cur] != -1) {
            return dp[cur];
        }

        if (cur > N) {
            return -1;
        }

        for (int i = cur + 1; i <= Math.min(N, cur + K); i++) {
            if (visited[i]) continue;
            if (f(i) == 0) {
                return dp[cur] = 1;
            }
        }

        return dp[cur] = 0;
    }
}