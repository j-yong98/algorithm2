import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static boolean[] visited;
    static long[] dist;
    static List<List<Node>> edges = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        dist = new long[N + 1];
        for (int i = 0; i <= N; i++) {
           edges.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            edges.get(A).add(new Node(B, C));
            edges.get(B).add(new Node(A, C));
        }

        dfs(1, 0);
        System.out.println(Arrays.stream(dist).max().getAsLong());
    }

    private static void dfs(int now, long cost) {
        visited[now] = true;

        for (Node next : edges.get(now)) {
            if (visited[next.v]) continue;
            dist[next.v] = next.w + cost;
            dfs(next.v, dist[next.v]);
        }
    }

    static class Node {
        int v;
        long w;

        public Node(int v, long w) {
            this.v = v;
            this.w = w;
        }
    }
}