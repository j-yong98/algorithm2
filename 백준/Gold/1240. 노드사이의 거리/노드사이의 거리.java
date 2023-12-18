import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static List<List<Node>> edges = new ArrayList<>();
    static boolean[] visited;
    static int ans;
    /**
     * 노드사이의 거리
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.get(u).add(new Node(v, w));
            edges.get(v).add(new Node(u, w));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            ans = 0;
            dfs(u, v, 0);
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    private static void dfs(int from, int to, int dist) {
        if (from == to) {
            ans = dist;
            return;
        }
        visited[from] = true;
        for (Node next : edges.get(from)) {
            if (visited[next.v]) continue;
            dfs(next.v, to, dist + next.w);
        }
        visited[from] = false;
    }

    static class Node {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}