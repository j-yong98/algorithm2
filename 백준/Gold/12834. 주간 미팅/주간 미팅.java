import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, V, E;
    static int A, B;
    static int[] arr;
    static List<List<Node>> edges = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i <= V; i++) {
            edges.add(new ArrayList<>());
        }
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.get(u).add(new Node(v, w));
            edges.get(v).add(new Node(u, w));
        }
        long sum = 0;
        for (int i = 0; i < N; i++) {
            int a = getDist(arr[i], A);
            int b = getDist(arr[i], B);
            sum += a + b;
        }
        System.out.println(sum);
    }

    private static int getDist(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.w, b.w));
        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[start] = 0;
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.w > dist[now.v]) {
                continue;
            }

            for (Node next : edges.get(now.v)) {
                if (now.w + next.w >= dist[next.v]) {
                    continue;
                }
                dist[next.v] = now.w + next.w;
                pq.add(new Node(next.v, dist[next.v]));
            }
        }

        return dist[end] == Integer.MAX_VALUE ? -1 : dist[end];
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