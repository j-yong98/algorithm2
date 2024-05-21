import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[][] dp;
    static boolean[] visited;
    static List<List<Integer>> edges = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }
        dp = new int[N + 1][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges.get(u).add(v);
            edges.get(v).add(u);
        }
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(f(1));
    }

    private static int f(int n) {
        if (n == N + 1) {
            return 0;
        }

        visited[n] = true;
        dp[n][0] = 0;
        dp[n][1] = arr[n];
        for (int next : edges.get(n)) {
            if (visited[next]) continue;

            dp[n][0] += f(next);
            dp[n][1] += dp[next][0];
        }
        return Math.max(dp[n][0], dp[n][1]);
    }

}