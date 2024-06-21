import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int A;
    static int B;
    /**
     * 공약수
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        B /= A; // lcm = a * b / gcd(a, b)
        int x = 0;
        int y = 0;
        for (int i = 1; i <= Math.sqrt(B); i++) {
            if (B % i == 0) {
                if (gcd(B / i, i) == 1) {
                    x = i * A;
                    y = B / i * A;
                }
            }
        }
        System.out.println(x + " " + y);
        br.close();
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
