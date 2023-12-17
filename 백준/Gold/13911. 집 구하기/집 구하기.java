import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 1_000_000_000;
    static final int HOME = 0;
    static final int MCDONALS = 1;
    static final int STARBUCKS = 2;
    static int V, E;
    static int M, x;
    static int S, y;
    static List<List<Node>> edges = new ArrayList<>();
    static int[] classify;
    static int[][] dist = new int[3][];
    /**
     * 집 구하기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        classify = new int[V + 1];
        for (int i = 0; i <= V + 2; i++) {
           edges.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.get(u).add(new Node(v, w));
            edges.get(v).add(new Node(u, w));
        }
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int v = Integer.parseInt(st.nextToken());
            edges.get(V + 1).add(new Node(v, 0));
            classify[v] |= MCDONALS;
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < S; i++) {
            int v = Integer.parseInt(st.nextToken());
            edges.get(V + 2).add(new Node(v, 0));
            classify[v] |= STARBUCKS;
        }
        dijkstra(V + 1, MCDONALS);
        dijkstra(V + 2, STARBUCKS);
        System.out.println(getMinDist(dist));
        br.close();
    }

    private static void dijkstra(int start, int state) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.w, b.w));
        dist[state] = new int[V + 3];
        Arrays.fill(dist[state], MAX);

        dist[state][start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.w > dist[state][now.v]) continue;

            for (Node next : edges.get(now.v)) {
                int cost = now.w + next.w;
                if (cost >= dist[state][next.v]) continue;
                dist[state][next.v] = cost;
                pq.add(new Node(next.v, cost));
            }
        }
    }

    private static int getMinDist(int[][] dist) {
        int min = MAX;
        for (int i = 1; i <= V; i++) {
            if (classify[i] != HOME) continue;
            if (dist[MCDONALS][i] > x || dist[STARBUCKS][i] > y) continue;
            min = Math.min(min, dist[MCDONALS][i] + dist[STARBUCKS][i]);
        }
        return min >= MAX ? -1 : min;
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