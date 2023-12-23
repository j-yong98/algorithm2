import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int N, K;
    static int[] arr;

    /**
     * 두 수의 합
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int l = 0;
            int r = N - 1;
            int res = Integer.MAX_VALUE;
            int ans = 0;
            while (l < r) {
                int sum = arr[l] + arr[r];

                int abs = Math.abs(sum - K);
                if (res > abs) {
                    ans = 1;
                    res = abs;
                } else if (res == abs) {
                    ans++;
                }
                if (sum <= K) {
                    l++;
                } else {
                    r--;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}