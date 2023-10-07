import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, P;
    static List<List<Node>> edges = new ArrayList<>();
    static List<Integer>[] path;
    static boolean flag = false;
    /**
     * 민준이와 마산 그리고 건우
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        path = new List[N + 1];
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
        reversePath(N);
        if (flag)
            System.out.println("SAVE HIM");
        else
            System.out.println("GOOD BYE");
        br.close();
    }

    private static void reversePath(int from) {
        if (flag) return;
        if (from == P) {
            flag = true;
            return;
        }
        if (from == 1) return;
        for (int to : path[from])
            reversePath(to);
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.w, b.w));
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[1] = 0;
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.w > dist[now.v]) continue;

            for (Node next : edges.get(now.v)) {
                if (next.w + dist[now.v] > dist[next.v]) continue;
                if (next.w + dist[now.v] == dist[next.v])
                    path[next.v].add(now.v);
                else {
                    dist[next.v] = dist[now.v] + next.w;
                    pq.add(new Node(next.v, dist[next.v]));
                    path[next.v] = new ArrayList();
                    path[next.v].add(now.v);
                }
            }
        }
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