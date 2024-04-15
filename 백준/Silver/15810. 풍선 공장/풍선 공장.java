import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        long max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        max *= M;
        long l = 0;
        long r = max;

        while (l <= r) {
            long mid = (l + r) >> 1;

            long cnt = 0;
            for (int i = 0; i < N; i++) {
                cnt += mid / arr[i];
            }

            if (cnt >= M) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(l);
    }
}

