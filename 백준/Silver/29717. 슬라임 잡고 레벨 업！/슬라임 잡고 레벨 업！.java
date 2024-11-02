import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T;
    static int l;
    static long n;
    static long e = 0;
    /**
     * 슬라임 잡고 레벨 업!
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            // 내가 받을 경험치 = 수열의 합 1~n까지
            e = (n * (n + 1)) / 2;
            // 내가 레벨 업할 때 필요한 경험치의 양 z * (z + 1)
            long l = 1;
            long r = Integer.MAX_VALUE;
            while (l < r) {
                long mid = (l + r) >> 1;
                long temp = mid * (mid + 1);
                if (temp <= e) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            sb.append(r).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}