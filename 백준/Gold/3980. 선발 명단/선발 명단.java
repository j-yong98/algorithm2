import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N = 11;
    static int[][] arr = new int[N][N];
    static int T;
    static int ans;
    /**
     * 선발 명단
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int ability = Integer.parseInt(st.nextToken());
                    arr[i][j] = ability;
                }
            }
            ans = 0;
            dfs(0, 0, 0);
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    private static void dfs(int n, int abilities, int visited) {
        if (n == N) {
            ans = Math.max(ans, abilities);
        }
        for (int i = 0; i < N; i++) {
            if ((visited & (1 << i)) != 0 || arr[n][i] == 0) continue;
            dfs(n + 1, abilities + arr[n][i], visited | (1 << i));
        }
    }
}