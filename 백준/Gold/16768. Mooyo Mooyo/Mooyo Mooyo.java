import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};
    static final int M = 10;
    static int N, K;
    static int[][] arr;
    static boolean[][] visited;
    static Deque<int[]> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++)
                arr[i][j] = line.charAt(j) - '0';
        }
        simulate();
        printMap();
    }

    private static void simulate() {
        boolean flag = false;
        for (int i = 0; i < N; i++)
            Arrays.fill(visited[i], false);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] || arr[i][j] == 0) continue;
                dfs(i, j);
                if (q.size() >= K) {
                    flag = true;
                    while (!q.isEmpty()) {
                        int[] pos = q.poll();
                        arr[pos[0]][pos[1]] = 0;
                    }
                }
                while (!q.isEmpty()) q.poll();
            }
        }
        fallDown();
        if (flag)
            simulate();
    }

    private static void printMap() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void fallDown() {
        for (int j = 0; j < M; j++) {
            int[] tmp = new int[N];
            int idx = N - 1;
            for (int i = N - 1; i >= 0; i--) {
                if (arr[i][j] == 0) continue;
                tmp[idx--] = arr[i][j];
            }
            for (int i = 0; i < N; i++)
                arr[i][j] = tmp[i];
        }
    }

    private static void dfs(int y, int x) {
        visited[y][x] = true;
        q.add(new int[]{y, x});
        for (int i = 0; i < 4; i++) {
            int yy = y + dy[i];
            int xx = x + dx[i];
            if (!inRange(yy, xx) || visited[yy][xx] || arr[yy][xx] != arr[y][x]) continue;
            dfs(yy, xx);
        }
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}