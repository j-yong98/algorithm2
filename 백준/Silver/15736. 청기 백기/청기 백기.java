import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    /**
     * 청기백기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int ans = 0;
        int k = 1;
        while (k * k <= N) {
            k++;
            ans++;
        }
        System.out.println(ans);

        br.close();
    }

}