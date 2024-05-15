import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int A, B, C;
    static char[] str1;
    static char[] str2;
    static int N, M;
    static int[][] dp;

    /**
     * 문자열과 정수
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        str1 = br.readLine().toCharArray();
        str2 = br.readLine().toCharArray();
        N = str1.length;
        M = str2.length;
        if (N < M) {
            swap(N, M);
            swap(str1, str2);
        }
        dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(f(0, 0));
        br.close();
    }

    private static int f(int n, int m) {
        if (n == N) {
            return (M - m) * B;
        }
        if (m == M) {
            return (N - n) * B;
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        dp[n][m] = Integer.MIN_VALUE;
        if (str1[n] == str2[m]) {
            dp[n][m] = f(n + 1, m + 1) + A;
        } else {
            int a = f(n + 1, m);
            int b = f(n, m + 1);
            dp[n][m] = Math.max(a, b) + B;
            dp[n][m] = Math.max(dp[n][m], f(n + 1, m + 1) + C);
        }
        return dp[n][m];
    }

    private static void swap(Object o1, Object o2) {
        Object temp = o1;
        o1 = o2;
        o2 = temp;
    }
}