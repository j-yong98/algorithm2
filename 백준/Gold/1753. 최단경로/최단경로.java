import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static int V, E;
    static int K;
    static List<List<Node>> edges = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        V = read();
        E = read();
        for (int i = 0; i <= V; i++) {
            edges.add(new ArrayList<>());
        }
        K = read();
        for (int i = 0; i < E; i++) {
            int u = read();
            int v = read();
            int w = read();
            edges.get(u).add(new Node(v, w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.w, b.w));
        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[K] = 0;
        pq.add(new Node(K, 0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.w > dist[now.v]) {
                continue;
            }

            for (Node next : edges.get(now.v)) {
                if (next.w + now.w >= dist[next.v]) {
                    continue;
                }
                dist[next.v] = now.w + next.w;
                pq.add(new Node(next.v, dist[next.v]));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            sb.append(dist[i] == Integer.MAX_VALUE ? "INF": dist[i]).append("\n");
        }
        System.out.print(sb);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13) System.in.read();
        return n;
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