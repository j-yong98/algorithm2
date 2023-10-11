import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 1_000_000_007;
    static int N;
    static long[] arr;
    static long[] ans = new long[]{MAX, MAX, MAX};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        for (int l = 0; l < N - 2; l++) {
            int mid = l + 1;
            int r = N - 1;
            while (mid < r) {
                long sum = arr[l] + arr[mid] + arr[r];
                if (Math.abs(sum) < Math.abs(Arrays.stream(ans).sum())) {
                    ans[0] = arr[l];
                    ans[1] = arr[mid];
                    ans[2] = arr[r];
                }
                if (sum < 0)
                    mid++;
                else
                    r--;
            }
        }
        Arrays.stream(ans).forEach(a -> System.out.print(a + " "));
    }
}