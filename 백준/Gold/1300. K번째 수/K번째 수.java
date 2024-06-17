import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, K;
    /**
     * K번쨰 수
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        long l = 0;
        long r = (long) N * N;

        long ans = 0;
        while (l <= r) {
            long m = (l + r) >> 1;

            if (check(m)) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        System.out.println(ans);
        br.close();
    }

    private static boolean check(long x) {
        long sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += Math.min(N, x / i);
        }
        return sum >= K;
    }
}