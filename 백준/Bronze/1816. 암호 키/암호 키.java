import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /**
     * 암호키
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());

            boolean flag = true;
            for (int j = 2; j <= 1_000_000; j++) {
                if (num % j == 0) {
                    flag = false;
                    break;
                }
            }
            sb.append(flag ? "YES\n" : "NO\n");
        }
        System.out.print(sb);
        br.close();
    }
}