import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int N = 5;
    static int[][] arr = new int[N][N];
    static int R, C;

    /**
     * 빠른 숫자 탐색
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Deque<int[]> q = new ArrayDeque<>();
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[R][C] = 0;
        q.add(new int[]{R, C, 0});
        int ans = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int[] now = q.pollFirst();

            if (arr[now[0]][now[1]] == 1) {
                ans = Math.min(ans, now[2]);
            }

            for (int i = 0; i < 4; i++) {
                int y = now[0] + dy[i];
                int x = now[1] + dx[i];
                if (!inRange(y, x) || dist[y][x] <= now[2] || arr[y][x] == -1) {
                    continue;
                }
                dist[y][x] = now[2] + 1;
                q.add(new int[]{y, x, now[2] + 1});
            }
        }
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
        br.close();
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }
}