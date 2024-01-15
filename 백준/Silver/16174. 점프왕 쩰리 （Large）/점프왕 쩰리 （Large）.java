import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] arr;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[][] visited = new boolean[N][N];
        visited[0][0] = true;

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});

        String ans = "Hing";
        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();
            int val = arr[pos[0]][pos[1]];

            if (pos[0] == N - 1 && pos[1] == N - 1) {
                ans = "HaruHaru";
                break;
            }
            for (int i = 0; i < 4; i++) {
                int y = pos[0] + dy[i] * val;
                int x = pos[1] + dx[i] * val;

                if (!inRange(y, x) || visited[y][x]) {
                    continue;
                }

                q.add(new int[]{y, x});
                visited[y][x] = true;
            }
        }
        System.out.println(ans);
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }
}