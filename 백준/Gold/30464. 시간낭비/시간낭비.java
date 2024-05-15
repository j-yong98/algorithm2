import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 200_000;
    static int[] dx = {-1, 1};
    static int N;
    static int[] arr = new int[MAX + 1];
    static int[][][] dp = new int[MAX + 1][2][3];
    /**
     * 시간낭비
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        int res = f(1, 1, 0);
        System.out.println(res < 1 ? -1 : res);
        br.close();
    }

    private static int f(int cur, int dir, int cnt) {
        if (cur == N) {
            return 0;
        }

        if (cur > N || cur < 1) {
            return Integer.MIN_VALUE;
        }

        if (dp[cur][dir][cnt] != -1) {
            return dp[cur][dir][cnt];
        }

        int nx = arr[cur] * dx[dir];
        if (nx != 0) {
            dp[cur][dir][cnt] = f(cur + nx, dir, cnt) + 1;
            if (cnt < 2) {
                dp[cur][dir][cnt] = Math.max(dp[cur][dir][cnt], f(cur - nx, dir ^ 1, cnt + 1) + 1);
            }
        }
        return dp[cur][dir][cnt];
    }
}