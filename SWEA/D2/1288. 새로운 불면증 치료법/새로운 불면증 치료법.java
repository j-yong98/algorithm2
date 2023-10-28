import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int n = 1;
            ans = 0;
            while (!allVisit()) {
                check(n * N);
                n++;
            }
            sb.append("#").append(t).append(" ").append((n - 1) * N).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean allVisit() {
        int tmp = ans;
        for (int i = 0; i < 10; i++) {
            if ((tmp & 1) == 0)
                return false;
            tmp >>= 1;
        }
        return true;
    }

    private static void check(int n) {
        while (n > 0) {
            int tmp = n % 10;
            ans |= (1 << tmp);
            n /= 10;
        }
    }
}