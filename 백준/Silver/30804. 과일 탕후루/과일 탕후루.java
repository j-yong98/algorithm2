import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static int[] cnt = new int[10];
    /**
     * 과일 탕후루
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int l = 0;
        int k = 0;

        int ans = 0;
        for (int r = 0; r < N; r++) {
            if (cnt[arr[r]]++ == 0) {
                k++;
            }

            while (k > 2) {
                if (--cnt[arr[l]] == 0) {
                    k--;
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        System.out.println(ans);
        br.close();
    }

    private static boolean check() {
        int c = 0;
        for (int i = 0; i < 10; i++) {
            if (cnt[i] > 0) {
                c++;
            }
        }
        return c <= 2;
    }
}