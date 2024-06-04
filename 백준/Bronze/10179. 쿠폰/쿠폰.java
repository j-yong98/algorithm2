import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /**
     * 쿠폰
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            double val = Double.parseDouble(br.readLine());
            val *= 0.8;
            val *= 100;
            val = (double) Math.round(val) * 0.01;
            System.out.printf("$%.2f\n", val);
        }
        br.close();
    }
}