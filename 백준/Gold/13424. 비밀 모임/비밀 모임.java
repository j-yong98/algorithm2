import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T;
    static int N, M, K;
    static List<List<Node>> edges;
    static int[] ans;
    static Deque<Integer> friends;
    /**
     * 비밀 모임
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            ans = new int[N + 1];
            edges = new ArrayList<>();
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
            K = Integer.parseInt(br.readLine());
            friends = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++)
                friends.add(Integer.valueOf(st.nextToken()));
            while (!friends.isEmpty())
                dijkstra(friends.pollFirst());
            int min = Integer.MAX_VALUE;
            int tmp = -1;
            for (int i = 1; i <= N; i++) {
                if (min > ans[i]) {
                    min = ans[i];
                    tmp = i;
                }
            }
            sb.append(tmp).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.w, b.w));
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (dist[now.v] < now.w) continue;

            for (Node next : edges.get(now.v)) {
                if (next.w + dist[now.v] >= dist[next.v]) continue;
                dist[next.v] = next.w + dist[now.v];
                pq.add(new Node(next.v, dist[next.v]));
            }
        }

        for (int i = 1; i <= N; i++)
            ans[i] += dist[i];
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