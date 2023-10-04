import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int MAX = 1_000_000_000;
    static int N, M, K;
    static int S, D;
    static int[] tax;
    static List<List<Node>> edges = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        tax = new int[K];
        for (int i = 0; i <= N; i++)
            edges.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.get(u).add(new Node(v, 1, w));
            edges.get(v).add(new Node(u, 1, w));
        }
        for (int i = 0; i < K; i++) {
            int t = Integer.parseInt(br.readLine());
            tax[i] = t;
        }
        dijkstra();
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.w, b.w));
        int[][] dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < N; j++)
                dist[i][j] = MAX;
        }

        dist[S][0] = 0;
        pq.add(new Node(S, 0, 0));


        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.w > dist[now.v][now.cnt]) continue;

            for (Node next : edges.get(now.v)) {
                if (dist[now.v][now.cnt] + next.w >= dist[next.v][now.cnt + 1] || now.cnt == D) continue;
                dist[next.v][now.cnt + 1] = dist[now.v][now.cnt] + next.w;
                pq.add(new Node(next.v, now.cnt + 1, dist[next.v][now.cnt + 1]));
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Arrays.stream(dist[D], 1, N).min().getAsInt()).append("\n");
        for (int i = 0; i < K; i++) {
            int min = MAX;
            for (int j = 1; j <= N; j++) {
                if (j == D) continue;
                dist[D][j] = dist[D][j] + (j * tax[i]);
                min = Math.min(min, dist[D][j]);
            }
            sb.append(min).append("\n");
        }
        System.out.print(sb);
    }

    static class Node {
        int v;
        int cnt;
        int w;

        public Node(int v, int cnt, int w) {
            this.v = v;
            this.cnt = cnt;
            this.w = w;
        }
    }
}