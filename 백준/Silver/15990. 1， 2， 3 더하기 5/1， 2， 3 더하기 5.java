import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 1000000009;
    static final int MAX = 100_000;
    static int[] arr;
    static int[][] dp = new int[MAX + 1][4];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        arr = new int[T];

        // Base case: 남은 합이 0일 때 어떤 prev라도 경우의 수는 1
        for (int j = 0; j < 4; j++) {
            dp[0][j] = 1;
        }
        int max = 0;
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            arr[t] = N;
            max = Math.max(max, arr[t]);
        }

        for (int n = 1; n <= max; n++) {
            for (int prev = 0; prev < 4; prev++) {
                // 1, 2, 3 중 이전에 사용한 수와 다른 수 선택
                for (int i = 1; i <= 3; i++) {
                    if (prev == i) continue; // 연속 같은 수는 안됨
                    if (n - i >= 0) {
                        dp[n][prev] = (dp[n][prev] + dp[n - i][i]) % MOD;
                    }
                }
            }
        }

        for (int i = 0; i < T; i++) {
            sb.append(dp[arr[i]][0]).append("\n");
        }
        System.out.print(sb);
    }
}