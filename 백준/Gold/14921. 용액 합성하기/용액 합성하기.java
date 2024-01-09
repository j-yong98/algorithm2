import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int l = 0;
        int r = N - 1;
        int ans = Integer.MAX_VALUE;
        while (l < r) {
            int sum = arr[l] + arr[r];
            if (sum == 0) {
                ans = 0;
                break;
            }
            if (Math.abs(sum) < Math.abs(ans)) {
                ans = sum;
            }
            if (sum < 0) {
                l++;
            } else {
                r--;
            }
        }
        System.out.println(ans);
    }
}