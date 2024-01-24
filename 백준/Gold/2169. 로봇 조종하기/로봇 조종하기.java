import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int[] dy = {0, 1, 0};
    static final int[] dx = {1, 0, -1};

    static int N, M;
    static int[][] arr;
    static int[][][] dp;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        dp = new int[N][M][3];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        System.out.println(Math.max(dfs(0, 0, 0), dfs(0, 0, 1)));
    }

    private static int dfs(int y, int x, int dir) {
        if (y == N - 1 && x == M - 1) {
            return arr[y][x];
        }
        if (dp[y][x][dir] != -1) {
            return dp[y][x][dir];
        }

        visited[y][x] = true;
        int result = -200000;
        for (int i = 0; i < 3; i++) {
            int yy = y + dy[i];
            int xx = x + dx[i];
            if (!inRange(yy, xx) || visited[yy][xx]) {
                continue;
            }
            result = Math.max(result, dfs(yy, xx, i) + arr[y][x]);
        }
        visited[y][x] = false;
        return dp[y][x][dir] = result;
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}