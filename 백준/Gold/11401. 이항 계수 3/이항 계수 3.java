import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MOD = 1_000_000_007;
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        long num = factorial(N);
        long denominator = (factorial(K) * factorial(N - K)) % MOD;
        long ans = (num * pow(denominator, MOD - 2)) % MOD;
        System.out.println(ans);
        br.close();
    }

    private static long pow(long n, int k) {
        if (k == 1) return n % MOD;

        long tmp = pow(n, k / 2);

        if (k % 2 == 1)
            return (tmp * tmp % MOD) * n % MOD;
        return (tmp * tmp) % MOD;
    }

    private static long factorial(int n) {
        long res = 1;
        while (n > 0) {
            res = (res * n) % MOD;
            n--;
        }
        return res;
    }
}
