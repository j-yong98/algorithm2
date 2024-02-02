import java.io.*;
import java.util.*;

public class Main {
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};
    static final int MAX = 10_000_000;
    static final char WALL = '#';
    static final char START = '@';
    static final char FIRE = '*';
    static int T;
    static int w, h;
    static char[][] arr;
    static int[] start = new int[2];
    static List<int[]> fires = new ArrayList<>();

    /**
     * 불
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String[] line = br.readLine().split(" ");
            w = Integer.parseInt(line[0]);
            h = Integer.parseInt(line[1]);
            arr = new char[h][w];
            for (int i = 0; i < h; i++) {
                String str = br.readLine();
                for (int j = 0; j < w; j++) {
                    arr[i][j] = str.charAt(j);
                    if (arr[i][j] == FIRE)
                        fires.add(new int[]{i, j});
                    else if (arr[i][j] == START) {
                        start[0] = i;
                        start[1] = j;
                    }
                }
            }
            int ans = bfs();
            bw.write(ans == -1 ? "IMPOSSIBLE\n" : ans + "\n");
            fires.clear();
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs() {
        boolean[][] visited = new boolean[h][w];
        Deque<int[]> q = new ArrayDeque<>();
        int[][] f = new int[h][w];
        for (int i = 0; i < h; i++)
            Arrays.fill(f[i], MAX);

        for (int[] fire : fires) {
            f[fire[0]][fire[1]] = 0;
            visited[fire[0]][fire[1]] = true;
            q.add(new int[]{fire[0], fire[1]});
        }

        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();
            for (int i = 0; i < 4; i++) {
                int y = pos[0] + dy[i];
                int x = pos[1] + dx[i];
                if (inRange(y, x) && !visited[y][x] && arr[y][x] != WALL) {
                    visited[y][x] = true;
                    f[y][x] = f[pos[0]][pos[1]] + 1;
                    q.add(new int[]{y, x});
                }
            }
        }

        for(int i = 0; i < h; i++)
            Arrays.fill(visited[i], false);
        visited[start[0]][start[1]] = true;
        q.add(new int[]{start[0], start[1], 0});
        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();
            for (int i = 0; i < 4; i++) {
                int y = pos[0] + dy[i];
                int x = pos[1] + dx[i];
                if (!inRange(y, x))
                    return pos[2] + 1;
                if (arr[y][x] != WALL && !visited[y][x] && f[y][x] > pos[2] + 1) {
                    visited[y][x] = true;
                    q.add(new int[]{y, x, pos[2] + 1});
                }
            }
        }
        return -1;
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < h && x >= 0 && x < w;
    }
}
