import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int ans = 0;
    static int[] checked;
    /**
     * 단풍잎 이야기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        checked = new int[M + 1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                int c = Integer.parseInt(st.nextToken());
                checked[i] |= (1 << c);
            }
        }
        f(0, 1, 0);
        System.out.println(ans);
        br.close();
    }

    private static void f(int n, int start, int visited) {
        if (n == N) {
            int cnt = 0;
            for (int i = 1; i <= M; i++) {
                if ((visited & (checked[i])) == checked[i]) {
                    cnt++;
                }
            }
            ans = Math.max(ans, cnt);
            return;
        }

        for (int i = start; i <= 2 * N; i++) {
            if ((visited & (1 << i)) != 0) continue;
            f(n + 1, i + 1, visited | (1 << i));
        }
    }
}