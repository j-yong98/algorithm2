import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[][] dp;
    static int[][] path;
    /**
     * 기업투자
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M + 1][N + 1];
        dp = new int[M + 1][N + 1];
        path = new int[M + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            for (int j = 1; j <= M; j++) {
                arr[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 0; k <= j; k++) {
                    if (dp[i][j] < dp[i - 1][j - k] + arr[i][k]) {
                        dp[i][j] = dp[i - 1][j - k] + arr[i][k];
                        path[i][j] = k;
                    }
                }
            }
        }
        System.out.println(dp[M][N]);
        int n = N;
        int m = M;
        Stack<Integer> stack = new Stack<>();
        while (m > 0) {
            stack.push(path[m][n]);
            n -= path[m][n];
            m--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}