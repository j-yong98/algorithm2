import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int[] dy = {-1, 1, 0, 0, -1, 1, -1, 1};
    static final int[] dx = {0, 0, -1, 1, -1, 1, 1, -1};
    static final char LOG = 'B';
    static final char GOAL = 'E';
    static final int OBSTACLE = 1;
    private static final int SIZE = 8;
    static int N;
    static int[][] arr;
    static int[][][] visited;
    static int[] pos = new int[SIZE];
    static List<int[]> goal = new ArrayList<>();
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new int[2][N][N];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }

        int idx = 0;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = line.charAt(j);
                if (c == LOG) {
                    pos[idx++] = i;
                    pos[idx++] = j;
                } else if (c == GOAL) {
                    goal.add(new int[]{i, j});
                } else {
                    arr[i][j] = c - '0';
                }
            }
        }

        Deque<int[]> q = new ArrayDeque<>();
        pos[6] = isVertical(pos);
        q.add(pos);
        visited[pos[6]][pos[2]][pos[3]] = 0;

        while (!q.isEmpty()) {
            int[] p = q.pollFirst();

            if (isFinish(p)) {
                ans = Math.min(ans, p[7]);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                if (canGo(p, i)) {
                    int[] next = go(p, i);
                    visited[next[6]][next[2]][next[3]] = next[7];
                    q.add(next);
                }
            }
            if (canRotate(p)) {
                int[] next = rotate(p);
                visited[next[6]][next[2]][next[3]] = next[7];
                q.add(next);
            }
        }
        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
    }

    private static void printMap(int[] pos) {
        int[][] tmp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tmp[i][j] = arr[i][j];
            }
        }

        for (int i = 0; i < 6; i += 2) {
            tmp[pos[i]][pos[i + 1]] = LOG;
        }
    }

    private static int isVertical(int[] pos) {
        return pos[0] + 1 == pos[2] && pos[2] + 1 == pos[4] ? 1 : 0;
    }

    private static int[] rotate(int[] pos) {
        int[] ret = new int[SIZE];
        ret[2] = pos[2];
        ret[3] = pos[3];
        if (pos[6] == 1) {
            ret[0] = pos[0] + 1;
            ret[1] = pos[1] - 1;
            ret[4] = pos[4] - 1;
            ret[5] = pos[5] + 1;
        } else {
            ret[0] = pos[0] - 1;
            ret[1] = pos[1] + 1;
            ret[4] = pos[4] + 1;
            ret[5] = pos[5] - 1;
        }
        ret[6] = pos[6] ^ 1;
        ret[7] = pos[7] + 1;
        return ret;
    }

    private static boolean canRotate(int[] pos) {
        int v = pos[6] ^ 1;
        if (visited[v][pos[2]][pos[3]] <= pos[7] + 1) {
            return false;
        }
        for (int i = 0; i < 8; i++) {
            int y = pos[2] + dy[i];
            int x = pos[3] + dx[i];
            if (!inRange(y, x) || arr[y][x] == OBSTACLE) {
                return false;
            }
        }
        return true;
    }

    private static int[] go(int[] pos, int dir) {
        int[] next = new int[SIZE];
        for (int i = 0; i < 6; i += 2) {
            next[i] = pos[i] + dy[dir];
            next[i + 1] = pos[i + 1] + dx[dir];
        }
        next[6] = pos[6];
        next[7] = pos[7] + 1;
        return next;
    }

    private static boolean canGo(int[] pos, int dir) {
        for (int i = 0; i < 6; i += 2) {
            int y = pos[i] + dy[dir];
            int x = pos[i + 1] + dx[dir];
            if (!inRange(y, x) || arr[y][x] == OBSTACLE) {
                return false;
            }
        }
        int y = pos[2] + dy[dir];
        int x = pos[3] + dx[dir];
        return visited[pos[6]][y][x] > pos[7] + 1;
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }

    private static boolean isFinish(int[] pos) {
        for (int[] p : goal) {
            if (!(pos[0] == p[0] && pos[1] == p[1])
                    && !(pos[2] == p[0] && pos[3] == p[1])
                    && !(pos[4] == p[0] && pos[5] == p[1])) {
                return false;
            }
        }
        return true;
    }
}