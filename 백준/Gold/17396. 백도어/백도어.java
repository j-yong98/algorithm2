import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static List<List<Node>> edges = new ArrayList<>();
    /**
     * 백도어
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++)
            edges.add(new ArrayList<>());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        arr[N - 1] = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.get(u).add(new Node(v, w));
            edges.get(v).add(new Node(u, w));
        }
        System.out.println(dijkstra());
        br.close();
    }

    private static long dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Long.compare(a.w, b.w));
        long[] dist = new long[N];
        Arrays.fill(dist, Long.MAX_VALUE);

        pq.add(new Node(0, 0));
        dist[0] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.w > dist[now.v] || arr[now.v] == 1) continue;

            for (Node next : edges.get(now.v)) {
                if (dist[next.v] <= dist[now.v] + next.w) continue;
                dist[next.v] = dist[now.v] + next.w;
                pq.add(new Node(next.v, dist[next.v]));
            }
        }
        return dist[N - 1] == Long.MAX_VALUE ? -1 : dist[N - 1];
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