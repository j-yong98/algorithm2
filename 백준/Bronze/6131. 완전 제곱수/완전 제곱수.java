import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /**
     * 완전 제곱수
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 1; i <= 500; i++) {
            for (int j = i; j <= 500; j++) {
                if (i * i + n == j * j) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        br.close();
    }
}