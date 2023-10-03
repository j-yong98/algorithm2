import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    //서 북 동 남
    static final int[] dy = {0, -1, 0, 1};
    static final int[] dx = {-1, 0, 1, 0};

    static int[][] arr;
    static int[][] mark;
    static boolean[][] visited;
    static int H, W;
    static int id = 0;
    static int max = 0;
    /**
     * 문제이름
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[H][W];
        mark = new int[H][W];
        visited = new boolean[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (visited[i][j]) continue;
                max = Math.max(max, bfs(i, j, ++id));
            }
        }
        sb.append(id).append("\n");
        sb.append(max).append("\n");

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (arr[i][j] == 0) continue;
                removeWall(i, j);
            }
        }
        sb.append(max).append("\n");
        System.out.print(sb);
        br.close();
    }

    private static void removeWall(int y, int x) {
        for (int i = 0; i < 4; i++) {
            if ((arr[y][x] & (1 << i)) == 0) continue;
            id = 0;
            for (int j = 0; j < H; j++) {
                Arrays.fill(visited[j], false);
                Arrays.fill(mark[j], 0);
            }
            arr[y][x] &= ~(1 << i);
            max = Math.max(max, bfs(y, x, ++id));
            arr[y][x] |= (1 << i);
        }
    }

    private static int bfs(int y, int x, int id) {
        int area = 1;
        Deque<int[]> q = new ArrayDeque<>();

        mark[y][x] = id;
        q.add(new int[]{y, x});
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();

            for (int i = 0; i < 4; i++) {
                int yy = pos[0] + dy[i];
                int xx = pos[1] + dx[i];
                if (!inRange(yy, xx) || visited[yy][xx] ||(arr[pos[0]][pos[1]] & (1 << i)) != 0) continue;
                area++;
                mark[yy][xx] = id;
                visited[yy][xx] = true;
                q.add(new int[]{yy, xx});
            }
        }
        return area;
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < H && x >= 0 && x < W;
    }
}