import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int[][] arr;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][2];
        dp = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[i][0] = h;
            arr[i][1] = c;
        }

        Arrays.sort(arr, 1, N + 1, (a, b) -> Integer.compare(a[0], b[0]));

        dp[1][0] = arr[1][1];
        for (int i = 2; i <= N; i++) {
            int idx = upper(1, i + 1, arr[i][0] - S);
            if (idx == i + 1) dp[i][0] = arr[i][1];
            else dp[i][0] = Math.max(dp[idx - 1][0], dp[idx - 1][1]) + arr[i][1];
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        }
        System.out.println(Math.max(dp[N][0], dp[N][1]));
    }

    private static int upper(int l, int r, int key) {
        while (l < r) {
            int mid = (l + r) >> 1;

            if (key >= arr[mid][0]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }
}

