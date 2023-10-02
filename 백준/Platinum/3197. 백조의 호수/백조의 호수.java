import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};
    static final char SWAN = 'L';
    static final char WALL = 'X';
    static final char BLANK = '.';

    static int R, C;
    static char[][] arr;
    static int[][] swan = new int[2][];
    static Deque<int[]> blanks = new ArrayDeque<>();
    static Deque<int[]> start = new ArrayDeque<>();
    static boolean[][] visited;

    /**
     * 백조의 호수
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++)
            arr[i] = br.readLine().toCharArray();
        int idx = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == SWAN) {
                    swan[idx++] = new int[]{i, j};
                    blanks.add(new int[]{i, j});
                }
                else if (arr[i][j] == BLANK)
                    blanks.add(new int[]{i, j});
            }
        }

        start.add(swan[0]);
        visited[swan[0][0]][swan[0][1]] = true;

        int cnt = 0;
        while (!move()) {
            bfs();
            cnt++;
        }
        System.out.println(cnt);
        br.close();
    }

    private static boolean move() {
        Deque<int[]> q = new ArrayDeque<>();

        while (!start.isEmpty()) {
            int[] now = start.pollFirst();

            if (now[0] == swan[1][0] && now[1] == swan[1][1])
                return true;
            for (int i = 0; i < 4; i++) {
                int y = now[0] + dy[i];
                int x = now[1] + dx[i];
                if (!inRange(y, x) || visited[y][x]) continue;
                visited[y][x] = true;
                if (arr[y][x] == WALL)
                    q.add(new int[]{y, x});
                else
                    start.add(new int[]{y, x});
            }
        }
        start = q;
        return false;
    }

    private static void bfs() {
        int size = blanks.size();
        for (int s = 0; s < size; s++) {
            int[] now = blanks.pollFirst();

            for (int i = 0; i < 4; i++) {
                int y = now[0] + dy[i];
                int x = now[1] + dx[i];
                if (!inRange(y, x) || arr[y][x] != WALL) continue;
                arr[y][x] = BLANK;
                blanks.add(new int[]{y, x});
            }
        }
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < R && x >= 0 && x < C;
    }
}