import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, W;
    static double limit;
    static Node[] nodes;
    static boolean[][] edges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        limit = Double.parseDouble(br.readLine());
        nodes = new Node[N];
        edges = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(x, y);
        }

        for (int i = 0; i < W; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            edges[u][v] = true;
            edges[v][u] = true;
        }

        System.out.println(dijkstra());
    }

    private static int dijkstra() {
        PriorityQueue<Node2> pq = new PriorityQueue<>((a, b) -> Double.compare(a.w, b.w));
        double[] dist = new double[N];
        Arrays.fill(dist, Double.MAX_VALUE);

        pq.add(new Node2(0, 0.0));
        dist[0] = 0.0;

        while (!pq.isEmpty()) {
            Node2 now = pq.poll();

            for (int i = 0; i < N; i++) {
                if (now.u == i || dist[i] <= now.w) continue;
                if (edges[now.u][i]) {
                    dist[i] = now.w;
                    pq.add(new Node2(i, now.w));
                } else {
                    double d = getDist(nodes[now.u], nodes[i]);
                    if (d > limit || now.w + d >= dist[i]) continue;
                    dist[i] = now.w + d;
                    pq.add(new Node2(i, now.w + d));
                }
            }

        }
        return (int) (dist[N - 1] * 1000);
    }

    private static double getDist(Node a, Node b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    static class Node2 {
        int u;
        double w;

        public Node2(int u, double w) {
            this.u = u;
            this.w = w;
        }
    }

    static class Node {
        double x;
        double y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}