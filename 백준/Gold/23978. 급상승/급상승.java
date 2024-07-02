import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long K;
    static int[] arr;

    /**
     * 급상승
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long l = 1;
        long r = 1_500_000_000;
        long ans = Long.MAX_VALUE;
        while (l <= r) {
            long m = (l + r) >> 1;

            long res = calc(m);
            if (res < K) {
                l = m + 1;
            } else {
                ans = Math.min(ans, m);
                r = m - 1;
            }
        }
        System.out.println(ans);
        br.close();
    }

    private static long calc(long key) {
        long res = (key * (key + 1)) / 2;
        for (int i = 1; i < N; i++) {
            long period = Math.min(key, arr[i] - arr[i - 1]);
            res += key * period - (period - 1) * period / 2;
        }
        return res;
    }
}