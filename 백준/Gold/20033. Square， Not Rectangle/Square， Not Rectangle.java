import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;

    /**
     * Square, Not Rectangle
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
        int r = Integer.MAX_VALUE;
        int ans = 0;
        while (l <= r) {
            int m = (l + r) >> 1;

            if (check(m)) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        System.out.println(ans);
        br.close();
    }

    private static boolean check(int key) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (key <= arr[i]) {
                cnt++;
                if (cnt == key) return true;
            } else {
                cnt = 0;
            }
        }
        return false;
    }
}