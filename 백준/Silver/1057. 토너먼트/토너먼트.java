import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K, L;
    /**
     *
     * K와 L이 나눴을 때 몫이 같으면 서로 붙는 것
     * K = 1, L = 5
     * 1 2 3 4 5 6 7 8
     * K의 몫을 p L의 몫을 q라고 하면 abs(L - K) = 1 min(L, K) % 2 = 1
     * 0 - 1 1 - 0 / 1 - 1 2 - 0 / 2 3 / 3 4
     * 1 3 5 7
     * 조의 개수는 N / 2개씩 나옴
     * 토너먼트
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        int round = 1;
        while (!check(K, L)) {
            K = f(K);
            L = f(L);
            round++;
        }
        System.out.println(round);
        br.close();
    }

    private static int f(int a) {
        int r = a % 2;
        a /= 2;
        if (r == 0) {
            return a;
        }
        return a + 1;
    }

    private static boolean check(int a, int b) {
        int min = Math.min(a, b);
        return min % 2 == 1 && Math.abs(a - b) == 1;
    }
}