import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] arr;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        Arrays.sort(arr);

        int max = 1;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                max = Math.max(max, f(i, j));
            }
        }
        System.out.println(max);
    }

    private static int f(int i, int j) {
        if (i > j) return 0;
        if (i == j) return 1;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        dp[i][j] = 2;

        int diff = arr[j] - arr[i];
        int next = arr[j] + diff;

        int idx = find(j + 1, N, next);

        if (idx == N || arr[idx] != next) return dp[i][j];
        return dp[i][j] = f(j, idx) + 1;
    }

    private static int find(int l, int r, int next) {
        while (l < r) {
            int m = (l + r) >> 1;

            if (arr[m] < next) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return r;
    }
}

