import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MAX = 45;
    static int K;
    /**
     * BABBA
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        f(0, 1, 0);
        br.close();
    }

    private static void f(int k, int a, int b) {
        if (k == K) {
            System.out.println(a + " " + b);
            return ;
        }

        f(k + 1, b, b + a);
    }

    /**
     * B를 누르면 BA
     * A를 누르면 A는 전부 B로
     *
     * 버튼을 누르면 B는 A의 개수 + B A는 B의 개수
     */
}