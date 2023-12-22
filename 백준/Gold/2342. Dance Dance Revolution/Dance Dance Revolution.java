import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int MAX = 100_000_000;
    static int N;
    static List<Integer> step = new ArrayList<>();
    static int[][][] dp;
    static int ans;
    /**
     * Dance Dance Revolution
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (true) {
            int num = Integer.parseInt(st.nextToken());
            if (num == 0) break;
            step.add(num);
        }
        N = step.size();
        dp = new int[N][5][5];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        ans = 0;
        play(0, 0, 0, 0);
        System.out.println(dp[0][0][0]);
        br.close();
    }

    private static int play(int n, int left, int right, int score) {
        if (n == N) {
            return score;
        }
        if (dp[n][left][right] != -1) {
            return dp[n][left][right];
        }
        dp[n][left][right] = MAX;
        int next = step.get(n);
        dp[n][left][right] = Math.min(dp[n][left][right], play(n + 1, next, right, score) + getScore(next, left));
        dp[n][left][right] = Math.min(dp[n][left][right], play(n + 1, left, next, score) + getScore(next, right));
        return dp[n][left][right];
    }

    private static int getScore(int next, int dir) {
        if (next == dir) {
            return 1;
        }
        if (dir == 0) {
            return 2;
        }
        if (Math.abs(next - dir) == 2) return 4;
        return 3;
    }
}