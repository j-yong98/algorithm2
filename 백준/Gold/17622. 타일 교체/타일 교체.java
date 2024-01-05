import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};
    static int N, K;
    static int[][] arr;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        change(0);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    private static void change(int cnt) {
        if (cnt == K) {
            int result = can();
            ans = Math.min(ans, result);
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k <= 5; k++) {
                    if (arr[i][j] == k) continue;
                    int tmp = arr[i][j];
                    arr[i][j] = k;
                    change(cnt + 1);
                    arr[i][j] = tmp;
                }
            }
        }
    }

    private static void printMap(int[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int can() {
        int cnt = 0;
        int y = 0;
        int x = 0;
        int dir = 3;
        while (true) {
            dir = go(dir, y, x);
            if (dir == -1) break;
            int yy = y + dy[dir];
            int xx = x + dx[dir];
            if (y == N - 1 && x == N - 1 && !inRange(yy, xx) && dir == 3) {
                return cnt + 1;
            }
            if (!inRange(yy, xx) || go(dir, yy, xx) == -1) break;
            y = yy;
            x = xx;
            cnt += 1;
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 북 남 서 동 (0, 1, 2, 3)
     */
    private static int go(int dir, int y, int x) {
        int shape = arr[y][x];
        if (shape == 0) { // 북(0) 서(2) -> 동(3) 남(1)
            if (dir == 0 || dir == 2) {
                return dir ^ 3;
            }
        } else if (shape == 1) { // 북(0) 동(3) -> 서(2) 남(1)
            if (dir == 0 || dir == 3) {
                return dir ^ 2;
            }
        } else if (shape == 2) { // 남(1) 서(2) -> 동(3) 북(0)
            if (dir == 1 || dir == 2) {
                return dir ^ 2;
            }
        } else if (shape == 3) { // 남(1) 동(3) -> 서(2) 북(0)
            if (dir == 1 || dir == 3) {
                return dir ^ 3;
            }
        } else if (shape == 4) { // 남 북 -> 북 남
            if (dir == 0 || dir == 1) {
                return dir;
            }
        } else { // 서 동 -> 동 서
            if (dir == 2 || dir == 3) {
                return dir;
            }
        }
        return -1;
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }
}
