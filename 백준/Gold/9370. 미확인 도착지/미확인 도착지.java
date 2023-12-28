
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T;
    static int N, M, K;
    static int S, G, H;
    static int[] goals;
    static Node e;
    static List<List<Node>> edges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            goals = new int[K];
            edges = new ArrayList<>();
            for (int i = 0; i <= N; i++)
                edges.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            G = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                edges.get(a).add(new Node(a, b, d));
                edges.get(b).add(new Node(b, a, d));
                if (Math.min(G, H) == Math.min(a, b) && Math.max(G, H) == Math.max(a, b))
                    e = new Node(Math.min(a, b), Math.max(a, b), d);
            }
            for (int i = 0; i < K; i++)
                goals[i] = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < K; i++) {
                if (dijkstra(goals[i]))
                    pq.add(goals[i]);
            }
            StringBuilder sb = new StringBuilder();
            while (!pq.isEmpty())
                sb.append(pq.poll()).append(" ");
            System.out.println(sb);
        }
    }

    private static boolean dijkstra(int goal) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
        int[] dist = new int[N + 1];
        List<Integer>[] path = new List[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[S] = 0;
        pq.add(new Node(S, S, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.w > dist[now.v]) continue;

            for (Node next : edges.get(now.v)) {
                if (next.w + dist[now.v] > dist[next.v]) continue;
                if (next.w + dist[now.v] == dist[next.v])
                    path[next.v].add(now.v);
                else {
                    dist[next.v] = dist[now.v] + next.w;
                    pq.add(new Node(now.u, next.v, dist[next.v]));
                    path[next.v] = new ArrayList<>();
                    path[next.v].add(now.v);
                }
            }
        }
        return pathSearch(goal, path);
    }

    private static boolean pathSearch(int now, List<Integer>[] path) {
        if (now == S || path[now] == null) return false;

        boolean res = false;
        for (int prev : path[now]) {
            if (Math.min(now, prev) == Math.min(G, H) && Math.max(now, prev) == Math.max(G, H))
                return true;
            res = pathSearch(prev, path);
            if (res) return true;
        }
        return res;
    }

    static class Node {
        int u;
        int v;
        int w;

        public Node(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
}