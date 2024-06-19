import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    /**
     * 최대 GCD
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int t = 0; t < N; t++) {
            List<Integer> list = new ArrayList<>();
                StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            int ans = 0;
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    int a = Math.max(list.get(i), list.get(j));
                    int b = Math.min(list.get(i), list.get(j));
                    ans = Math.max(ans, gcd(a, b));
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}