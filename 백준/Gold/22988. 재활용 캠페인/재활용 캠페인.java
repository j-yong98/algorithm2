import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static long X;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Long.parseLong(st.nextToken());
        arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        int l = 0;
        int r = N - 1;
        int res = 0;
        int cnt = 0;
        long min = Math.round((double) X / 2);
        while (l <= r) {
            if (arr[r] >= X) {
                res++;
                r--;
                continue;
            }
            long val = arr[l] + arr[r];
            if (l < r && val >= min) {
                res++;
                l++;
                r--;
            } else {
                cnt++;
                l++;
            }
        }
        System.out.println(res + cnt / 3);
    }
}