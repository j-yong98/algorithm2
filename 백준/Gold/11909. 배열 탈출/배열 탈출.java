import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static final int[] dy = {1, 0};
    static final int[] dx = {0, 1};
    static int N;
    static int[][] arr;
    static int[][] cost;

    /**
     * 배열 탈출
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] cost = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++)
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.add(new int[]{1, 1, 0});
        cost[1][1] = 0;
        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            if (cost[now[0]][now[1]] < now[2]) continue;

            if (now[0] == N && now[1] == N) {
                System.out.println(now[2]);
                return;
            }
            for (int i = 0; i < 2; i++) {
                int y = now[0] + dy[i];
                int x = now[1] + dx[i];
                int c = now[2];
                if (!inRange(y, x)) continue;
                if (arr[y][x] >= arr[now[0]][now[1]]) {
                    c += (arr[y][x] - arr[now[0]][now[1]]) + 1;
                }
                if (c >= cost[y][x]) continue;
                cost[y][x] = c;
                pq.add(new int[]{y, x, c});
            }
        }
        br.close();
    }

    private static boolean inRange(int y, int x) {
        return y >= 1 && y <= N && x >= 1 && x <= N;
    }
}