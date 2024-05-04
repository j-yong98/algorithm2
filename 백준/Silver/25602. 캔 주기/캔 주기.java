import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[] a;
    static int[][] r;
    static int[][] m;
    static int ans = 0;
    /**
     * 캔 주기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        a = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        r = new int[K][N];
        m = new int[K][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                r[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                m[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        f(0, 0);
        System.out.println(ans);
        br.close();
    }

    private static void f(int l, int sum) {
        if (l == K) {
            ans = Math.max(ans, sum);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (a[i] == 0) continue;
            a[i]--;
            for (int j = 0; j < N; j++) {
                if (a[j] == 0) continue;
                a[j]--;
                f(l + 1, sum + r[l][i] + m[l][j]);
                a[j]++;
            }
            a[i]++;
        }
    }
}