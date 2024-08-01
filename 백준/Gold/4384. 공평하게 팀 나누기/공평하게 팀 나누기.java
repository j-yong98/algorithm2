import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int MAX = 45000;
    static int N;
    static int[] arr;
    static int[][] dp;
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N * 2][MAX * 2];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        dp[0][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = N / 2; j >= 0; j--) {
                for (int k = MAX; k >= 0; k--) {
                    if (dp[j][k] == 0) {
                        continue;
                    }
                    dp[j + 1][k + arr[i]] = 1;
                }
            }
        }


        int diff = Integer.MAX_VALUE;
        int a = 0;
        int b = 0;
        for (int i = 0; i <= MAX; i++) {
            int temp = Math.abs(i - (sum - i));
            if (dp[N / 2][i] > 0 && diff > temp) {
                diff = temp;
                a = i;
                b = sum - i;
            }
        }
        System.out.println(Math.min(a, b) + " " + Math.max(a, b));
    }
}