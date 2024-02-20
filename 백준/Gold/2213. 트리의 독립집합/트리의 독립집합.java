import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static int[][] dp;
    static boolean[] visited;
    static List<List<Integer>> edges = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        visited = new boolean[N + 1];
        dp = new int[N + 1][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }

        String line = null;
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges.get(u).add(v);
            edges.get(v).add(u);
        }

        getMax(1);
        Arrays.fill(visited, false);
        trace(1, 0);
        Collections.sort(path);
        StringBuilder sb = new StringBuilder();
        sb.append(Math.max(dp[1][0], dp[1][1])).append("\n");
        path.forEach(a -> sb.append(a).append(" "));
        System.out.println(sb);
    }

    private static void trace(int now, int prev) {
        if (dp[now][1] > dp[now][0] && !visited[prev]) {
            path.add(now);
            visited[now] = true;
        }

        for (int next : edges.get(now)) {
            if (visited[next] || prev == next) {
                continue;
            }
            trace(next, now);
        }
    }

    private static void getMax(int now) {
        //포함 안했을 때
        dp[now][0] = 0;
        //포함 했을 때
        dp[now][1] = arr[now];
        visited[now] = true;

        for (int next : edges.get(now)) {
            if (visited[next]) {
                continue;
            }

            getMax(next);
            dp[now][0] += Math.max(dp[next][0], dp[next][1]);
            dp[now][1] += dp[next][0];
        }
    }
}