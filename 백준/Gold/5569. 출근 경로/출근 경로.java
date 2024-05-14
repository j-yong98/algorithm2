import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int MOD = 100_000;
    static final int MAX = 100;

    static int[] dy = {0, 1};
    static int[] dx = {1, 0};
    static int[][][][] dp = new int[MAX + 1][MAX + 1][2][2];
    static int W, H;
    /**
     * 출근 경로
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= H; i++) {
            for (int j = 0; j <= W; j++) {
                for (int k = 0; k < 2; k++) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }
        int a = f(1, 2, 0, 1);
        int b = f(2, 1, 1, 1);
        System.out.println((a + b) % MOD);
        br.close();
    }

    private static int f(int y, int x, int dir, int flag) {
        if (y == H && x == W) {
            return 1;
        }

        if (dp[y][x][dir][flag] != -1) {
            return dp[y][x][dir][flag];
        }

        dp[y][x][dir][flag] = 0;
        for (int i = 0; i < 2; i++) {
            int yy = y + dy[i];
            int xx = x + dx[i];
            if (!inRange(yy, xx)) continue;
            if (dir == i) {
                dp[y][x][dir][flag] = (dp[y][x][dir][flag] + f(yy, xx, i, 1)) % MOD;
            } else {
                if (flag == 0) continue;
                dp[y][x][dir][flag] = (dp[y][x][dir][flag] + f(yy, xx, i, 0)) % MOD;
            }
        }
        return dp[y][x][dir][flag];
    }

    private static boolean inRange(int y, int x) {
        return y >= 1 && y <= H && x >= 1 && x <= W;
    }
}