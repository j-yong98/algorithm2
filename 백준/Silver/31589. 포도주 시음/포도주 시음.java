import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] arr;
    /**
     * 포도주 시식
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
        Arrays.sort(arr);
        int cnt = K / 2;
        int l = 0;
        int r = N - 1;
        long ans = 0;
        while (cnt-- > 0) {
            ans += arr[r] - arr[l];
            l++; r--;
        }
        if (K % 2 == 1) {
            ans += arr[r];
        } else {
            ans += arr[l - 1];
        }
        System.out.println(ans);
        br.close();
    }
}