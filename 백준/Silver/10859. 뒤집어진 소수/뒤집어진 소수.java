import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /**
     * 뒤집어진 소수
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long num = Long.parseLong(br.readLine());
        long reverse = reverseNumber(num);
        if (isPrime(num) && isPrime(reverse)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
        br.close();
    }

    private static long reverseNumber(long x) {
        long temp = 0;
        while (x > 0) {
            long r = x % 10;
            x /= 10;
            if (r == 1 || r == 0 || r == 2 || r == 5 || r == 8) {
                temp = (temp * 10) + r;
            } else if (r == 6) {
                temp = (temp * 10) + 9;
            } else if (r == 9) {
                temp = (temp * 10) + 6;
            } else {
                return 1;
            }
        }
        return temp;
    }

    private static boolean isPrime(long x) {
        if (x == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}