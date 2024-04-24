import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    /**
     * 2017 연세대학교 프로그래밍 경시 대회
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = 2; k < n; k+=2) {
                    if (i + j + k != n) continue;
                    if (i < j + 2) continue;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        br.close();
    }
}