import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

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
        arr = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) {
                    continue;
                }
                cnt++;
                bfs(i, j);
            }
        }
        System.out.println(cnt);
    }

    private static void bfs(int y, int x) {
        Deque<int[]> q = new ArrayDeque<>();
        visited[y][x] = true;
        q.addLast(new int[]{y, x});

        while (!q.isEmpty()) {
            int[] now = q.pollFirst();

            for (int i = 0; i < 4; i++) {
                int yy = now[0] + dy[i];
                int xx = now[1] + dx[i];
                if (!inRange(yy, xx) || visited[yy][xx] || Math.abs(arr[now[0]][now[1]] - arr[yy][xx]) > K) {
                    continue;
                }
                visited[yy][xx] = true;
                q.addLast(new int[]{yy, xx});
            }
        }
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}