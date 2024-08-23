import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static int N, M;
    /**
     * 0의 개수
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int count = 0;
            for (int i = n; i <= m; i++) {
                if (i == 0) {
                    count++;
                    continue;
                }
                int num = i;
                while (num > 0) {
                    int r = num % 10;
                    if (r == 0) {
                        count++;
                    }
                    num /= 10;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}