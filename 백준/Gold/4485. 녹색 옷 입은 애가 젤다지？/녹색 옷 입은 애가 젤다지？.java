import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int N;
    static int[][] arr;
    static PriorityQueue<int[]> pq;
    static boolean[][] visited;
    static int testCase = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            testCase += 1;
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            arr = new int[N][N];
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++)
                    arr[i][j] = Integer.parseInt(st.nextToken());
            }
            pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
            visited[0][0] = true;
            pq.add(new int[]{0, 0, arr[0][0]});
            while (!pq.isEmpty()) {
                int[] now = pq.poll();

                if (now[0] == N - 1 && now[1] == N - 1) {
                    sb.append("Problem ").append(testCase).append(": ").append(now[2]).append("\n");
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int yy = now[0] + dy[i];
                    int xx = now[1] + dx[i];
                    if (!inRange(yy, xx) || visited[yy][xx]) continue;
                    visited[yy][xx] = true;
                    pq.add(new int[]{yy, xx, now[2] + arr[yy][xx]});
                }
            }
        }
        System.out.print(sb);
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }
}