import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int MOD = 1_000_000_007;
    static int N, M;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = new int[]{a, b};
        }
        dp = new int[N][2];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(f(0, 0));
    }

    private static int f(int n, int flag) {
        if (n == N) {
            return 1;
        }

        if (dp[n][flag] != -1) {
            return dp[n][flag];
        }

        int cnt = 0;

        // 맞게 추는 경우
        for (int i = 1; i <= M; i++) {
            if (arr[n][1] == 0 && arr[n][0] == i) {
                cnt += f(n + 1, flag);
            } else if (arr[n][1] == 1 && arr[n][1] != i) {
                cnt += f(n + 1, flag);
            }
            cnt %= MOD;
        }

        // 틀리게 추는 경우
        if (flag == 0) {
            for (int i = 1; i <= M; i++) {
                if (arr[n][1] == 0 && arr[n][0] != i) {
                    cnt += f(n + 1, 1);
                } else if (arr[n][1] == 1 && arr[n][1] == i) {
                    cnt += f(n + 1, 1);
                }
                cnt %= MOD;
            }
        }
        return dp[n][flag] = cnt;
    }
}