import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static int[] cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        cnt = new int[11];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int l = 0;
        int r = 0;
        cnt[arr[0]]++;
        int ans = 1;
        while (r < N - 1) {
            r++;
            cnt[arr[r]]++;

            int min = 0, max = 10;
            while (min <= 10 && cnt[min] == 0) min++;
            while (max >= 0 && cnt[max] == 0) max--;

            while (max - min > 2) {
                cnt[arr[l]]--;
                l++;

                if (l > r) break;

                min = 0; max = 10;
                while (min <= 10 && cnt[min] == 0) min++;
                while (max >= 0 && cnt[max] == 0) max--;
            }
            ans = Math.max(ans, r - l + 1);
        }
        System.out.println(ans);
    }
}
