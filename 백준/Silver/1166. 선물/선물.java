import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, L, W, H;
    /**
     * 선물
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        double l = 0, r = 1_000_000_000;
        while (l <= r) {
            double mid = (l + r) / 2;

            if ((long)(L / mid) * (long)(W / mid) * (long)(H / mid) >= N) {
                if (l == mid) break;
                l = mid;
            } else {
                if (r == mid) break;
                r = mid;
            }
        }
        System.out.println(l);
        br.close();
    }
}