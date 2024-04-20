import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M, L;
    static int[] arr;

    /**
     * 휴게소 세우기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[N + 2];
        if (N > 0) {
            st = new StringTokenizer(br.readLine());
        }
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[N] = 0;
        arr[N + 1] = L;
        Arrays.sort(arr);

        int l = 1;
        int r = L;

        while (l < r) {
            int mid = (l + r) >> 1;

            int cnt = 0;
            for (int i = 1; i < N + 2; i++) {
                int dist = arr[i] - arr[i - 1];

                cnt += dist / mid;
                if (dist % mid == 0) cnt--;
            }

            if (cnt > M) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        System.out.println(r);
    }
}