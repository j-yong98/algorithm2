import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static class Dice {
        int up;
        int right;
        int front;

        public Dice() {
            this.up = 1;
            this.right = 3;
            this.front = 5;
        }
    }
    static int n, m, k;
    static int[][] arr;
    static Dice dice = new Dice();
    static int y = 0;
    static int x = 0;
    static int dir = 0;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    /**
     * 주사위 굴리기2
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        long ans = 0;
        for (int i = 0; i < k; i++) {
            moveDice();
            setDir(7 - dice.up, arr[y][x]);
            ans += getScore();
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
    private static long getScore() {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        q.add(new int[]{y, x});
        visited[y][x] = true;
        int cnt = 1;
        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();
            for (int i = 0; i < 4; i++) {
                int yy = pos[0] + dy[i];
                int xx = pos[1] + dx[i];
                if (inRange(yy, xx) && !visited[yy][xx] && arr[pos[0]][pos[1]] == arr[yy][xx]) {
                    cnt++;
                    visited[yy][xx] = true;
                    q.add(new int[] {yy, xx});
                }
            }
        }
        return arr[y][x] * cnt;
    }
    private static void setDir(int a, int b) {
        if (a > b)
            dir = (dir + 1) % 4;
        else if (a < b)
            dir = (dir - 1 + 8) % 4;
    }
    private static void moveDice() {
        int yy = y + dy[dir];
        int xx = x + dx[dir];
        if (!inRange(yy, xx)) {
            dir = dir == 2 || dir == 3 ? dir - 2 : dir + 2;
            yy = y + dy[dir];
            xx = x + dx[dir];
        }
        y = yy;
        x = xx;
        if (dir == 0) {
            int tmp = dice.up;
            dice.up = 7 - dice.right;
            dice.right = tmp;
        }
        else if (dir == 1) {
            int tmp = dice.up;
            dice.up = 7 - dice.front;
            dice.front = tmp;
        }
        else if (dir == 2) {
            int tmp = dice.right;
            dice.right = 7 - dice.up;
            dice.up = tmp;
        }
        else if (dir == 3) {
            int tmp = dice.front;
            dice.front = 7 - dice.up;
            dice.up = tmp;
        }
    }

    private static boolean inRange(int yy, int xx) {
        return yy >= 0 && yy < n && xx >= 0 && xx < m;
    }
}
