import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static final char MIRROR = '!';
    static final char DOOR = '#';
    static final char WALL = '*';
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};
    static int N;
    static char[][] arr;
    static int[][] door;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        door = new int[2][];
        int idx = 0;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j);
                if (arr[i][j] == DOOR)
                    door[idx++] = new int[]{i, j};
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[3], b[3]));
        int[][][] count = new int[4][N][N];
        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < N; i++) {
                Arrays.fill(count[k][i], Integer.MAX_VALUE);
            }
        }

        for (int i = 0; i < 4; i++) {
            int y = door[0][0] + dy[i];
            int x = door[0][1] + dx[i];
            if (!inRange(y, x) || arr[y][x] == WALL) continue;
            q.add(new int[]{door[0][0], door[0][1], i, 0});
            count[i][door[0][0]][door[0][1]] = 0;
        }

        while (!q.isEmpty()) {
            int[] pos = q.poll();

            if (pos[0] == door[1][0] && pos[1] == door[1][1])
                return pos[3];
            if (pos[3] > count[pos[2]][pos[0]][pos[1]]) continue;

            int y = pos[0] + dy[pos[2]];
            int x = pos[1] + dx[pos[2]];

            if (!inRange(y, x) || arr[y][x] == WALL) continue;
            if (arr[y][x] == MIRROR) {
                int[] dir = getDir(pos[2]);
                for (int i = 0; i < dir.length; i++) {
                    if (count[dir[i]][y][x] <= pos[3] + 1) continue;
                    count[pos[2]][y][x] = pos[3] + 1;
                    q.add(new int[]{y, x, dir[i], pos[3] + 1});
                }
            }
            if (count[pos[2]][y][x] <= pos[3]) continue;
            count[pos[2]][y][x] = pos[3];
            q.add(new int[]{y, x, pos[2], pos[3]});
        }
        return Integer.MAX_VALUE;
    }

    private static int[] getDir(int d) {
        if (d == 0 || d == 1)
            return new int[]{2, 3};
        return new int[]{0, 1};
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }
}