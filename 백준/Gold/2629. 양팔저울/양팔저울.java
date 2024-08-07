import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] a;
    static int[] b;
    static boolean[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new boolean[N + 1][N * 500 + 1];
        a = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        b = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        f(0, 0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) { //내가 확인할 구슬
            if (b[i] > N * 500) {
                sb.append("N ");
            }
            else if (dp[N][b[i]]) {
                sb.append("Y ");
            } else {
                sb.append("N ");
            }
        }
        System.out.println(sb);
    }

    private static void f(int l, int w) {
        if (l > N) {
            return;
        }

        if (dp[l][w]) {
            return;
        }

        dp[l][w] = true;
        f(l + 1, w);
        f(l + 1, w + a[l]);
        f(l + 1, Math.abs(w - a[l]));
    }
}