import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 1000;
    static int N;
    static int[][] arr;
    static int[] tmp = new int[3];
    static int ans = 0;
    /**
     * 숫자 야구
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][5];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            for (int j = 2; j >= 0; j--) {
                arr[i][j] = num % 10;
                num /= 10;
            }
            arr[i][3] = strike;
            arr[i][4] = ball;
        }
        br.close();
        f(0, 0);
        System.out.println(ans);
    }

    private static void f(int n, int visited) {
        if (n == 3) {
            if (check()) {
                ans++;
            }
            return;
        }

        for (int i = 1; i < 10; i++) {
            if ((visited & (1 << i)) != 0) {
                continue;
            }
            tmp[n] = i;
            f(n + 1, visited | (1 << i));
        }
    }

    private static boolean check() {
        for (int i = 0; i < N; i++) {
            int[] guess = arr[i];

            if (!getStrike(guess) || !getBall(guess)) {
                return false;
            }
        }
        return true;
    }

    private static boolean getStrike(int[] guess) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (guess[i] == tmp[i]) {
                cnt++;
            }
        }
        return cnt == guess[3];
    }

    private static boolean getBall(int[] guess) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            int a = guess[i];
            for (int j = 0; j < 3; j++) {
                if (i != j && a == tmp[j]) {
                    cnt++;
                }
            }
        }
        return cnt == guess[4];
    }
}