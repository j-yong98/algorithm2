import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<List<Integer>> edges = new ArrayList<>();
    static int[][] dp;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][2];
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++)
            edges.add(new ArrayList<>());
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges.get(u).add(v);
            edges.get(v).add(u);
        }
        visited[1] = true;
        find(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    private static void find(int cur) {
        dp[cur][0] = 1;
        visited[cur] = true;

        for (int next : edges.get(cur)) {
            if (visited[next]) continue;
            find(next);
            dp[cur][1] += dp[next][0];
            dp[cur][0] += Math.min(dp[next][0], dp[next][1]);
        }
    }

}