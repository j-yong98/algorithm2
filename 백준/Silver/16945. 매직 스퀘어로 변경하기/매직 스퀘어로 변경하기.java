import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int N = 3;
    static int[][] arr = new int[N][N];
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        f(0, 0, 0, 0);
        System.out.println(ans);
    }

    private static void f(int y, int x, int cost, int visited) {
        if (cost > ans) return;
        if (allEqual()) {
            ans = cost;
            return;
        }

        if (y == N) {
            return;
        }
        if (x == N) {
            f(y + 1, 0, cost, visited);
            return;
        }

        int now = arr[y][x];
        for (int i = 1; i <= 9; i++) {
            if ((visited & (1 << i)) != 0) continue;
            arr[y][x] = i;
            f(y, x + 1, cost + Math.abs(now - i), visited | (1 << i));
            arr[y][x] = now;
        }
    }

    private static boolean allEqual() {
        int row = 0;
        int col = 0;
        int cross1 = 0;
        int cross2 = 0;
        for (int i = 0; i < N; i++) {
            int r = 0;
            for (int j = 0; j < N; j++) {
                r += arr[i][j];
            }
            if (i == 0) {
                row = r;
            } else if (row != r){
                return false;
            }
        }

        for (int i = 0; i < N; i++) {
            int c = 0;
            for (int j = 0; j < N; j++) {
                c += arr[j][i];
            }
            if (i == 0) {
                col = c;
            } else if (col != c) {
                return false;
            }
        }

        for (int i = 0; i < N; i++) {
            cross1 += arr[i][i];
            cross2 += arr[N - i - 1][i];
        }
        return row == 15 && col == 15 && cross1 == 15 && cross2 == 15;
    }
}

