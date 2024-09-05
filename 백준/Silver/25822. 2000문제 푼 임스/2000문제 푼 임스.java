import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static double C;
    static int N;
    static int[] arr;
    static int max = 0, ans = 0;

    /**
     * 2000문제 임스
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        C = Double.parseDouble(br.readLine());
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int val = Integer.parseInt(st.nextToken());
            max = Math.max(max, val);
            arr[i] = val > 0 ? 0 : 1;
        }
        for (int i = 1; i <= N; i++) {
            arr[i] += arr[i - 1];
        }
        int cnt = (int) Math.min(2, C / 0.99);
        int l = 1, r = 1;
        while (r <= N) {
            if (arr[r] - arr[l - 1] <= cnt) {
                ans = Math.max(ans, r - l + 1);
                r++;
            } else {
                l++;
            }
        }
        System.out.println(ans + "\n" + max);
        br.close();
    }

}