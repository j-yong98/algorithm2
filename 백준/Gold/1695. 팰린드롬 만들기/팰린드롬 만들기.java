import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[][] dp;

    /**
     * 팰린드롬 만들기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(f(0, N - 1));
        br.close();
    }

    private static int f(int start, int end) {
        if (start >= end) {
            return 0;
        }

        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        dp[start][end] = Integer.MAX_VALUE;
        if (arr[start] == arr[end]) {
            dp[start][end] = Math.min(dp[start][end], f(start + 1, end - 1));
        } else {
            dp[start][end] = Math.min(dp[start][end], f(start + 1, end) + 1);
            dp[start][end] = Math.min(dp[start][end], f(start, end - 1) + 1);
        }
        return dp[start][end];
    }
}