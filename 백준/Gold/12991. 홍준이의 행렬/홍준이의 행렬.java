import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[][] arr = new int[2][];
    /**
     * 홍준이의 행렬
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 2; i++) {
            arr[i] = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 2; i++) {
            Arrays.sort(arr[i]);
        }
        long l = 0;
        long r = (long) arr[0][N - 1] * arr[1][N - 1];
        long ans = 0;
        while (l <= r) {
            long m = (l + r) >> 1;
            if (!check(m)) {
                l = m + 1;
            } else {
                ans = m;
                r = m - 1;
            }
        }
        System.out.println(ans);
        br.close();
    }

    private static boolean check(long x) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            long key = x / arr[0][i];
            int l = 0;
            int r = N;
            while (l < r) {
                int m = (l + r) >> 1;

                if (arr[1][m] <= key) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            sum += r;
        }
        return sum >= K;
    }
}