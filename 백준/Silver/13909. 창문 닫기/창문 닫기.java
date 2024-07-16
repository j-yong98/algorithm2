import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    /**
     * 창문 닫기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 1; i * i <= N; i++) {
            cnt++;
        }
        System.out.println(cnt);
        br.close();
    }
}