import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 10;
    static int N, F;
    static int[][] arr;
    static boolean isFinish = false;
    /**
     * 수들의 합 6
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        f(0, 0);
        br.close();
    }

    private static void f(int n, int visited) {
        if (isFinish) {
            return;
        }
        if (n == N) {
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < N - i; j++) {
                    arr[i][j] = arr[i - 1][j] + arr[i - 1][j + 1];
                }
            }
            if (arr[N - 1][0] == F) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i <  N; i++) {
                    sb.append(arr[0][i]).append(" ");
                }
                System.out.println(sb);
                isFinish = true;
            }
            return;
        }

        for (int i = 1; i <= N; i++) {
            if ((visited & (1 << i)) != 0) continue;
            arr[0][n] = i;
            f(n + 1, visited | (1 << i));
        }
    }
}