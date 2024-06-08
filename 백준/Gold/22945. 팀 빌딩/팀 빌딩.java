import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    /**
     * 팀 빌딩
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
        int r = N - 1;
        int ans = 0;
        while (l < r) {
            int res = Math.min(arr[l], arr[r]) * (r - l - 1);

            if (arr[l] < arr[r]) {
                l++;
            } else {
                r--;
            }
            ans = Math.max(ans, res);
        }
        System.out.println(ans);
        br.close();
    }
}