import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, D;
    static List<List<Node>> edges = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= D; i++)
            edges.add(new ArrayList<>());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if (a > D || b > D) continue;
            edges.get(a).add(new Node(b, w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.w, b.w));
        int[] dist = new int[D + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        pq.add(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.w > dist[now.v]) continue;

            if (now.v < D && now.w + 1 < dist[now.v + 1]) {
                dist[now.v + 1] = now.w + 1;
                pq.add(new Node(now.v + 1, dist[now.v + 1]));
            }
            for (Node next : edges.get(now.v)) {
                if (next.v > D || next.w + now.w >= dist[next.v]) continue;
                dist[next.v] = now.w + next.w;
                pq.add(new Node(next.v, dist[next.v]));
            }
        }
        System.out.println(dist[D]);
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