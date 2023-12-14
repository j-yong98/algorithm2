import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 10_000_000;
    static final char BLANK = '.';
    static final char OBSTACLE = '+';
    static final char NOT_USED = '@';
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};

    static int N, M;
    static char[][] arr;
    static int[][] dist;
    static int[][] hole = new int[2][];

    /**
     * 미로
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        findHole();
        bfs();
        markMap();
        printMap();

        br.close();
    }

    private static void printMap() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void markMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == OBSTACLE) {
                    continue;
                }
                arr[i][j] = NOT_USED;
            }
        }
        Deque<int[]> path = new ArrayDeque<>();
        path.add(new int[]{hole[1][0], hole[1][1]});
        arr[hole[1][0]][hole[1][1]] = BLANK;

        while (!path.isEmpty()) {
            int[] pos = path.pollFirst();

            for (int i = 0; i < 4; i++) {
                int y = pos[0] + dy[i];
                int x = pos[1] + dx[i];

                if (!inRange(y, x) || arr[y][x] == OBSTACLE) {
                    continue;
                }
                if (dist[y][x] == dist[pos[0]][pos[1]] - 1) {
                    arr[y][x] = BLANK;
                    path.add(new int[]{y, x});
                }
            }
        }
    }

    private static void bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], MAX);
        }

        q.add(new int[]{hole[0][0], hole[0][1]});
        dist[hole[0][0]][hole[0][1]] = 0;

        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();

            if (pos[0] == hole[1][0] && pos[1] == hole[1][1]) {
                break;
            }
            for (int i = 0; i < 4; i++) {
                int y = pos[0] + dy[i];
                int x = pos[1] + dx[i];

                if (!inRange(y, x) || dist[y][x] <= dist[pos[0]][pos[1]] + 1 || arr[y][x] == OBSTACLE) {
                    continue;
                }
                dist[y][x] = dist[pos[0]][pos[1]] + 1;
                q.add(new int[]{y, x});
            }
        }
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }

    private static void findHole() {
        int idx = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i][0] == BLANK) {
                hole[idx++] = new int[]{i, 0};
            } else if (arr[i][M - 1] == BLANK) {
                hole[idx++] = new int[]{i, M - 1};
            }
        }

        for (int i = 1; i < M - 1; i++) {
            if (arr[0][i] == BLANK) {
                hole[idx++] = new int[]{0, i};
            } else if (arr[N - 1][i] == BLANK) {
                hole[idx++] = new int[]{N - 1, i};
            }
        }
    }
}