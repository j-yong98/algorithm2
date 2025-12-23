import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long N, R;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        R = Long.parseLong(st.nextToken());

        long temp = N - R;
        long ans = 0;
        for (long i = 1; i <= N / i; i++) {
            if (temp % i > 0) {
                continue;
            }
            long r = temp / i;
            if (i > R) {
                ans += i;
            }
            if (i != r && r > R) {
                ans += r;
            }
        }
        System.out.println(ans);
    }
}
