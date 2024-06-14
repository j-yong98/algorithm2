import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] arr;
    /**
     * 이상한 술집
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long l = 0;
        long r = Integer.MAX_VALUE;
        while (l <= r) {
            long m = (l + r) >> 1;

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                cnt += arr[i] / m;
            }

            if (cnt >= K) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        System.out.println(r);
        br.close();
    }
}