import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] dp;

    /**
     * 조를 잘짰을 때 최댓값을 구하는게 목적
     * 조의 개수는 1 ~ N개 가능
     * Math.max(sum(min - max))를 구해야함
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N];
        Arrays.fill(dp, -1);
        System.out.println(f(0));
    }

    private static int f(int n) {
        if (n == N) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = 0;
        int min = arr[n];
        int max = arr[n];
        for (int i = n + 1; i < N; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            dp[n] = Math.max(dp[n], max - min + f(i + 1));
        }
        return dp[n];
    }
}