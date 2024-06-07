import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int SIZE = 100_000;
    static int N, K, B;
    static boolean[] arr = new boolean[SIZE + 1];
    /**
     * 소가 길을 건너간 이유 5
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        for (int i = 0; i < B; i++) {
            int val = Integer.parseInt(br.readLine());
            arr[val] = true;
        }

        int l = 1;
        int r;
        int cnt = 0;
        for (r = 1; r < K; r++) {
            if (arr[r]) {
                cnt++;
            }
        }
        if (arr[r]) {
            cnt++;
        }
        int ans = cnt;

        while (r < N) {
            l++;
            r++;
            if (arr[l - 1]) {
                cnt--;
            }
            if (arr[r]) {
                cnt++;
            }
            ans = Math.min(cnt, ans);
        }
        ans = Math.min(cnt, ans);
        System.out.println(ans);
        br.close();
    }
}