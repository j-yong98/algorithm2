import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static List<List<Node>> edges = new ArrayList<>();
    /**
     * 네트워크 복구
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= N; i++)
            edges.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.get(u).add(new Node(v, w));
            edges.get(v).add(new Node(u, w));
        }
        dijkstra();
        br.close();
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.w, b.w));

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        int[] path = new int[N + 1];

        dist[1] = 0;
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.w > dist[now.v]) continue;

            for (Node next : edges.get(now.v)) {
                if (dist[now.v] + next.w >= dist[next.v]) continue;
                dist[next.v] = now.w + next.w;
                pq.add(new Node(next.v, dist[next.v]));
                path[next.v] = now.v;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(N - 1).append("\n");
        for (int i = 2; i <= N; i++)
            sb.append(path[i]).append(" ").append(i).append("\n");
        System.out.print(sb);
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