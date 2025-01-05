import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;
    static int ans = 1;

    /**
     * 친구 팰린드롬
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u][v] = 1;
            arr[v][u] = 1;
        }
        f(1, 0, 0);
        System.out.println(ans);
        br.close();
    }

    private static void f(int n, int visited, int cnt) {
        if (n == N + 1) {
            int flag = cnt < N ? 1 : 0;
            ans = Math.max(ans, (cnt) + flag);
            return;
        }

        if ((visited & (1 << n)) != 0) {
            f(n + 1, visited, cnt);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (i == n) continue;
            if (arr[n][i] == 0) continue;
            if ((visited & (1 << i)) != 0) continue;
            f(n + 1, visited | (1 << i) | (1 << n), cnt + 2);
        }
        f(n + 1, visited, cnt);
    }
}