import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, B, W;
    static char[] arr;

    /**
     * 준표와 조약돌
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        arr = br.readLine().toCharArray();
        int ans = 0;
        int l = 0;
        int r = 0;
        int bCnt = arr[l] == 'B' ? 1 : 0;
        int wCnt = bCnt ^ 1;

        while (r < N - 1) {
            if (bCnt <= B && wCnt >= W) {
                ans = Math.max(ans, r - l + 1);
            }

            while (l <= r && bCnt > B) {
                if (arr[l] == 'B') {
                    bCnt--;
                } else {
                    wCnt--;
                }
                l++;
            }
            if (arr[++r] == 'B') {
                bCnt++;
            } else {
                wCnt++;
            }
        }
        if (bCnt <= B && wCnt >= W) {
            ans = Math.max(ans, r - l + 1);
        }
        System.out.println(ans);
        br.close();
    }
}