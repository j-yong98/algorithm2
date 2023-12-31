import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] parent;
    static PriorityQueue<Node> edges = new PriorityQueue<>((a, b) -> Integer.compare(a.w, b.w));
    static PriorityQueue<Node> reverseEdges = new PriorityQueue<>((a, b) -> -Integer.compare(a.w, b.w));

    /**
     * 학교 탐방하기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        int start = 0;
        for (int i = 0; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Node(a, b, c ^ 1));
            reverseEdges.add(new Node(a, b, c ^ 1));
        }
        init();
        int res1 = kruskal(edges);
        init();
        int res2 = kruskal(reverseEdges);
        System.out.println(res2 * res2 - res1 * res1);
        br.close();
    }

    private static void init() {
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
    }

    private static int kruskal(PriorityQueue<Node> pq) {
        int weight = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (findParent(now.u) != findParent(now.v)) {
                union(now.u, now.v);
                weight += now.w;
            }
        }

        return weight;
    }

    private static void union(int a, int b) {
        int p1 = findParent(a);
        int p2 = findParent(b);

        if (p1 != p2) {
            parent[p2] = p1;
        }
    }

    private static int findParent(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = findParent(parent[a]);
    }

    static class Node {
        int u;
        int v;
        int w;

        public Node(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
}