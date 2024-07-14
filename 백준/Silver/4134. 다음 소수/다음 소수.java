import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            long n = Long.parseLong(br.readLine());
            while (!findPrime(n)) {
                n++;
            }
            sb.append(n).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean findPrime(long start) {
        if (start <= 1) {
            return false;
        }
        for (long i = 2; i <= Math.sqrt(start); i++) {
            if (start % i == 0) {
                return false;
            }
        }
        return true;
    }
}