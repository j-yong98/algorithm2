import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T;
    static long N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Long.parseLong(br.readLine());
            String binary = Long.toBinaryString(N);
            long ans = 0;
            for (int i = binary.length() - 1; i >= 0; i--) {
                if (binary.charAt(i) == '1') {
                    long pow = 1;
                    for (int j = binary.length() - 1; j > i; j--) {
                        pow *= 3;
                    }
                    ans += pow;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
