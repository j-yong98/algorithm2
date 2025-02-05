import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int R, C;
    static char[][] arr;
    static boolean[][] visited;
    static int o = 0, v = 0;

    /**
     * 양
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == 'o') {
                    o += 1;
                } else if (arr[i][j] == 'v') {
                    v += 1;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (visited[i][j]) {
                    continue;
                }
                bfs(i, j);
            }
        }

        System.out.println(o + " " + v);
        br.close();
    }

    private static void bfs(int y, int x) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y, x});
        int oo = 0;
        int vv = 0;
        while (!q.isEmpty()) {
            int[] now = q.pollFirst();
            if (arr[now[0]][now[1]] == 'o') {
                oo++;
            } else if (arr[now[0]][now[1]] == 'v') {
                vv++;
            }

            for (int i = 0; i < 4; i++) {
                int yy = now[0] + dy[i];
                int xx = now[1] + dx[i];
                if (!inRange(yy, xx) || visited[yy][xx] || arr[yy][xx] == '#') {
                    continue;
                }
                visited[yy][xx] = true;
                q.add(new int[]{yy, xx});
            }
        }
        if (oo > vv) {
            v -= vv;
        } else {
            o -= oo;
        }
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < R && x >= 0 && x < C;
    }
}