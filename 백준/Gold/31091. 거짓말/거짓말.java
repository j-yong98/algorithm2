import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sum = new int[N + 2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x > 0) { // x 명 이상 -> x 명 미만을 거짓 (0 ~ x - 1 까지)
                sum[0] += 1;
                sum[x] -= 1;
            } else { // x 명 이하 -> x 명 초과는 거짓 (x + 1 ~ N까지)
                x = -x;
                sum[x + 1] += 1;
                sum[N + 1] -= 1;
            }
        }

        for (int i = 1; i <= N; i++) {
            sum[i] += sum[i - 1];
        }
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i <= N; i++) {
            if (i == sum[i]) {
                cnt++;
                sb.append(i).append(" ");
            }
        }
        System.out.println(cnt);
        System.out.println(sb.toString().trim());
    }

}
