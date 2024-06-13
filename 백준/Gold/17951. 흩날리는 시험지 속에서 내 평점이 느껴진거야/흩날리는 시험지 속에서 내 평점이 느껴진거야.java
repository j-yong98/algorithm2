import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] arr;
    /**
     * 흩날리는 시험지 속에서 내 평점이 느껴진거야
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int r = 10_000_000;

        while (l <= r) {
            int m = (l + r) >> 1;

            int res = 0;
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                res += arr[i];
                if (res >= m) {
                    res = 0;
                    cnt++;
                }
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