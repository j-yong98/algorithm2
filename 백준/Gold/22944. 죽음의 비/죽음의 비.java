import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};
    static final char START = 'S';
    static final char UMBRELLA = 'U';
    static final char END = 'E';
    static final char BLANK = '.';

    static int N, H, D;
    static char[][] arr;
    static int[] start;
    static List<int[]> umbrella = new ArrayList<>();
    static int[] end;
    static int remain;


    /**
     * 죽음의 비
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == BLANK) {
                    continue;
                }
                if (arr[i][j] == START) {
                    start = new int[]{i, j};
                } else if (arr[i][j] == UMBRELLA) {
                    umbrella.add(new int[]{i, j, 1});
                } else if (arr[i][j] == END) {
                    end = new int[]{i, j};
                }
                arr[i][j] = BLANK;
            }
        }
        int result = bfs(start, end, new int[]{start[0], start[1], 0, 0, H, 0});
        System.out.println(result);
        br.close();
    }

    private static int bfs(int[] src, int[] target, int[] status) {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[umbrella.size() + 1][N][N];

        q.add(status);
        visited[0][src[0]][src[1]] = true;
        while (!q.isEmpty()) {
            int[] now = q.pollFirst();

            if (now[4] == 0) continue;
            remain = now[4];
            if (now[0] == target[0] && now[1] == target[1]) {
                return now[2];
            }

            for (int i = 0; i < 4; i++) {
                int y = now[0] + dy[i];
                int x = now[1] + dx[i];
                if (!inRange(y, x) || visited[now[5]][y][x]) continue;
                visited[now[5]][y][x] = true;
                if (isUmbrella(y, x)) {
                    q.add(new int[]{y, x, now[2] + 1, D, now[4], now[5] + 1});
                } else {
                    if (now[3] == 0) {
                        q.add(new int[]{y, x, now[2] + 1, now[3], now[4] - 1, now[5]});
                    } else {
                        q.add(new int[]{y, x, now[2] + 1, now[3] - 1, now[4], now[5]});
                    }
                }
            }
        }
        return -1;
    }

    private static boolean isUmbrella(int y, int x) {
        for (int[] pos : umbrella) {
            if (pos[0] == y && pos[1] == x && pos[2] == 1) {
                pos[2] = 0;
                return true;
            }
        }
        return false;
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }
}