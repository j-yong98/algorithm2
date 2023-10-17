import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    /**
     * 물병
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int ans = 0;
        while (true) {
            int tmp = N;
            int count = 0;
            while (tmp > 0) {
                int r = tmp % 2;
                tmp >>= 1;
                count += r;
            }
            if (count <= K) break;
            N++;
            ans++;
        }
        System.out.println(ans);
        br.close();
    }
}