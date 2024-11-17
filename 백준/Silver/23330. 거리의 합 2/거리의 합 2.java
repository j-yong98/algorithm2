import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static long[] sum;

    /**
     * 거리의 합2
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        sum = new long[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        /*
         * 1 2 3 4 5
         * (4 - 1), (4 - 2), (4 - 3)
         * 4 * 3 - (1 + 2 + 3)
         */
        long ans = 0;
        for (int i = 1; i <= N; i++) {
            ans += ((long) arr[i] * (i - 1)) - sum[i - 1];
        }
        System.out.println(ans * 2);
    }
}