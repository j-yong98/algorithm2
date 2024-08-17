import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /**
     * 연속부분최대곱
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[] arr = new double[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }
        double max = 0;
        for (int i = 0; i < N; i++) {
            double val = arr[i];
            max = Math.max(max, val);
            for (int j = i + 1; j < N; j++) {
                val *= arr[j];
                max = Math.max(max, val);
            }
        }
        System.out.printf("%.3f", max);
        br.close();
    }
}