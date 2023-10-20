import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static int N;
    static int[][] arr;
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        int max = 0;
        int min = 201;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
                min = Math.min(min, arr[i][j]);
            }
        }

        int left = 0;
        int right = max - min;
        int ans = 201;
        while (left <= right) {
            int mid = (left + right) >> 1;

            boolean flag = false;
            for (int i = min; i <= max; i++) {
                if (i <= arr[0][0] && arr[0][0] <= i + mid) {
                    flag = bfs(i, i + mid);
                    if (flag)
                        break;
                }
            }
            if (flag) {
                ans = Math.min(ans, mid);
                right = mid - 1;
            }
            else
                left = mid + 1;
        }
        System.out.println(ans);
        br.close();
    }

    private static boolean bfs(int s, int e) {
        boolean[][] dist = new boolean[N][N];
        Deque<int[]> q = new ArrayDeque<>();

        q.add(new int[]{0, 0});
        dist[0][0] = true;
        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();

            if (pos[0] == N - 1 && pos[1] == N - 1)
                return true;
            for (int i = 0; i < 4; i++) {
                int yy = pos[0] + dy[i];
                int xx = pos[1] + dx[i];
                if (!inRange(yy, xx) || dist[yy][xx]) continue;
                if (arr[yy][xx] < s || arr[yy][xx] > e) continue;
                dist[yy][xx] = true;
                q.add(new int[]{yy, xx});
            }
        }
        return false;
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }
}