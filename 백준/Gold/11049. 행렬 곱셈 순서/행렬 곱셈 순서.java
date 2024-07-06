import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 500;
    static int N;
    static int[][] dp;
    static boolean[] visited;
    static int[][] arr;

    /**
     * 행렬 곱셈 순서
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        dp = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(f(0, N - 1));
        br.close();
    }

    private static int f(int x, int y) {
        if (x == y) {
            return 0;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = Integer.MAX_VALUE;
        for (int i = x; i < y; i++) {
            dp[x][y] = Math.min(dp[x][y], f(x, i) + f(i + 1, y) + calc(arr[x][0], arr[i + 1][0], arr[y][1]));
        }
        return dp[x][y];
    }

    private static int calc(int n, int m, int k) {
        return n * m * k;
    }
}