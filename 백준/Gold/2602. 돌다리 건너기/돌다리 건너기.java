import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, M;
    static char[] str;
    static char[][] stone = new char[2][];
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine().toCharArray();
        stone[0] = br.readLine().toCharArray();
        stone[1] = br.readLine().toCharArray();
        N = stone[0].length;
        M = str.length;
        dp = new int[N][M][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        System.out.println(f(0, 0, 0) + f(0, 0, 1));
    }

    private static int f(int n, int m, int idx) {
        if (m == M) {
            return 1;
        }
        if (n == N) {
            return 0;
        }
        if (dp[n][m][idx] != -1) {
            return dp[n][m][idx];
        }

        char ch = stone[idx][n];
        char target = str[m];
        dp[n][m][idx] = 0;
        if (ch == target) {
            dp[n][m][idx] += f(n + 1, m + 1, idx ^ 1);
        }
        dp[n][m][idx] += f(n + 1, m, idx);
        return dp[n][m][idx];
    }
}