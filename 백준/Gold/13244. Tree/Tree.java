import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int N, M;
    static List<List<Integer>> edges = new ArrayList<>();
    static boolean[] visited;
    /**
     * Tree
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            visited = new boolean[N + 1];
            for (int i = 0; i <= N; i++)
                edges.add(new ArrayList<>());
            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                edges.get(a).add(b);
                edges.get(b).add(a);
            }
            if (M != N - 1) sb.append("graph\n");
            else {
                int d = dfs(1, 1);
                if (d != N) sb.append("graph\n");
                else sb.append("tree\n");
            }
        }
        System.out.print(sb);
        br.close();
    }

    private static int dfs(int now, int depth) {
        if (visited[now]) return 0;
        visited[now] = true;
        for (int next : edges.get(now))
            depth += dfs(next, 1);
        return depth;
    }
}