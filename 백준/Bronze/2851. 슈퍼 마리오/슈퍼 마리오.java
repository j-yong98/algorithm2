import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    /**
     * 슈퍼 마리오
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            int mush = sum + Integer.parseInt(br.readLine());
            if (Math.abs(100 - sum) < Math.abs(100 - mush)) {
                break;
            }
            sum = mush;
        }
        System.out.println(sum);
        br.close();
    }
}