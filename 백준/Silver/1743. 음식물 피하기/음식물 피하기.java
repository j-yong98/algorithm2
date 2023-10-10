import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};
    static int N, M, K;
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr[y][x] = 1;
        }
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (visited[i][j] || arr[i][j] == 0) continue;
                ans = Math.max(ans, bfs(i, j));
            }
        }
        System.out.println(ans);
    }

    private static int bfs(int y, int x) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y, x});
        visited[y][x] = true;

        int cnt = 1;
        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();

            for (int i = 0; i < 4; i++) {
                int yy = pos[0] + dy[i];
                int xx = pos[1] + dx[i];
                if (!inRange(yy, xx) || visited[yy][xx] || arr[yy][xx] == 0) continue;
                visited[yy][xx] = true;
                q.add(new int[]{yy, xx});
                cnt++;
            }
        }
        return cnt;
    }

    private static boolean inRange(int y, int x) {
        return y >= 1 && y <= N && x >= 1 && x <= M;
    }
}