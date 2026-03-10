import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        long l = 0;
        long r = 10000000000000L;
        while (l < r - 1) {
            long mid = (l + r) >> 1;
            long res = 0;
            for (int i = 0; i < N; i++) {
                res += Math.min(arr[i], mid);
            }
            if (res >= mid * K) {
                l = mid;
            } else {
                r = mid;
            }
        }
        System.out.println(l);
    }
}