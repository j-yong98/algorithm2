import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] dy = {0, 1};
    static int[] dx = {1, 0};
    static int T;
    static int N, K;
    static char[][] arr;
    static int[][][][] dp;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new char[N][];
            dp = new int[N][N][2][K + 1];
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < 2; k++) {
                        Arrays.fill(dp[i][j][k], -1);
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                arr[i] = br.readLine().toCharArray();
            }
            sb.append(f(dy[0], dx[0], 0, 0) + f(dy[1], dx[1], 1, 0)).append("\n");
        }
        System.out.println(sb);
    }

    private static int f(int y, int x, int dir, int k) {
        if (!inRange(y, x) || arr[y][x] == 'H') return 0;

        if (y == N - 1 && x == N - 1) {
            return 1;
        }

        if (dp[y][x][dir][k] != -1) {
            return dp[y][x][dir][k];
        }

        dp[y][x][dir][k] = 0;
        for (int i = 0; i < 2; i++) {
            if (dir != i && k == K) continue;
            int ny = y + dy[i];
            int nx = x + dx[i];
            int nk = dir != i ? k + 1 : k;
            dp[y][x][dir][k] += f(ny, nx, i, nk);
        }
        return dp[y][x][dir][k];
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }
}