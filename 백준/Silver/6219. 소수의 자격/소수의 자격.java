import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 4_000_000;
    static boolean[] isPrime = new boolean[MAX + 1];

    /**
     * 소수의 자격
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        for (int i = 2; i <= Math.sqrt(MAX); i++) {
            if (isPrime[i]) {
                continue;
            }
            for (int j = i * i; j <= MAX; j += i) {
                isPrime[j] = true;
            }
        }
        int ans = 0;
        for (int i = A; i <= B; i++) {
            if (!isPrime[i] && contains(i, C)) {
                ans++;
            }
        }
        System.out.println(ans);
        br.close();
    }

    private static boolean contains(int x, int d) {
        while (x > 0) {
            int r = x % 10;
            x /= 10;
            if (r == d) {
                return true;
            }
        }
        return false;
    }
}