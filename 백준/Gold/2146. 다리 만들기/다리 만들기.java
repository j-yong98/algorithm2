import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};
    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static int ans = Integer.MAX_VALUE;
    /**
     * 다리 만들기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++)
                arr[i][j] = Integer.parseInt(line[j]);
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    mark(i, j, ++cnt);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) continue;
                check(i, j);
            }
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void check(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int yy = y + dy[i];
            int xx = x + dx[i];
            if (inRange(yy, xx) && arr[yy][xx] == 0)
                ans = Math.min(ans, searchMinBridge(yy, xx, arr[y][x]));
        }
    }

    private static int searchMinBridge(int y, int x, int num) {
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++)
            Arrays.fill(visited[i], false);
        q.add(new int[]{y, x, 0});
        visited[y][x] = true;
        int res = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();
            for (int i = 0; i < 4; i++) {
                int yy = pos[0] + dy[i];
                int xx = pos[1] + dx[i];
                if (!inRange(yy, xx)) continue;
                if (visited[yy][xx]) continue;
                visited[yy][xx] = true;
                if (arr[yy][xx] == 0)
                    q.add(new int[]{yy, xx, pos[2] + 1});
                else if (arr[yy][xx] != num)
                    res = Math.min(res, pos[2] + 1);
            }
        }
        return res;
    }

    private static void mark(int y, int x, int num) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y, x});
        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();
            arr[pos[0]][pos[1]] = num;
            for (int i = 0; i < 4; i++) {
                int yy = pos[0] + dy[i];
                int xx = pos[1] + dx[i];
                if (inRange(yy, xx) && !visited[yy][xx] && arr[yy][xx] == 1) {
                    visited[yy][xx] = true;
                    q.add(new int[]{yy, xx});
                }
            }
        }
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }
}
