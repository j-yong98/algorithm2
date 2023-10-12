import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static Deque<int[]> orders = new ArrayDeque<>();
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        makeMoveSeq();
        move();
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }

    private static void makeMoveSeq() {
        boolean[][] visited = new boolean[n][n];
        int y = 0;
        int x = 0;
        int dir = 0;
        orders.add(new int[]{0, 0, (dir + 2) % 4});
        visited[0][0] = true;
        while (true) {
            if (y == n / 2 && x == n / 2)
                break;
            int yy = y + dy[dir];
            int xx = x + dx[dir];
            if (!inRange(yy, xx) || visited[yy][xx]) {
                dir = (dir + 1) % 4;
                yy = y + dy[dir];
                xx = x + dx[dir];
            }
            orders.addLast(new int[]{yy, xx, (dir + 2) % 4});
            visited[yy][xx] = true;
            y = yy;
            x = xx;
        }
    }

    private static void move() {
        while (!orders.isEmpty()) {
            int[] info = orders.pollLast();
            if (info[0] == 0 && info[1] == 0)
                break;
            int y = info[0] + dy[info[2]];
            int x = info[1] + dx[info[2]];
            Deque<int[]> blowSand = blow(y, x, info[2]);
            while (!blowSand.isEmpty()) {
                int[] pos = blowSand.pollFirst();
                if (!inRange(pos[0], pos[1]))
                    ans += pos[2];
                else
                    arr[pos[0]][pos[1]] += pos[2];
            }
            arr[y][x] = arr[info[0]][info[1]];
        }
    }

    private static Deque<int[]> blow(int y, int x, int dir) {
        Deque<int[]> q = new ArrayDeque<>();
        int[][][] ratio = {
                {
                        {-1, 1, -1, 1, -1, 1, -2, 2, 0, 0}, {-1, -1, 0, 0, 1, 1, 0, 0, 2, 1}
                },
                {
                        {-1, -1, 0, 0, 1, 1, 0, 0, 2, 1}, {-1, 1, -1, 1, -1, 1, -2, 2, 0, 0}
                },
                {
                        {-1, 1, -1, 1, -1, 1, -2, 2, 0, 0}, {1, 1, 0, 0, -1, -1, 0, 0, -2, -1}
                },
                {
                        {1, 1, 0, 0, -1, -1, 0, 0, -2, -1}, {-1, 1, -1, 1, -1, 1, -2, 2, 0, 0}
                }
        };
        double[] amount = {0.01, 0.01, 0.07, 0.07, 0.1, 0.1, 0.02, 0.02, 0.05};
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int yy = y + ratio[dir][0][i];
            int xx = x + ratio[dir][1][i];
            int sand = (int) (arr[y][x] * amount[i]);
            if (sand == 0)
                continue;
            sum += sand;
            q.add(new int[]{yy, xx, sand});
        }
        q.add(new int[]{y + ratio[dir][0][9], x + ratio[dir][1][9], arr[y][x] - sum});
        return q;
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }
}
