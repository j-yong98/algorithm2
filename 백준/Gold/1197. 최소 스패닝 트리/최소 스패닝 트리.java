import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
    static int[] table;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        table = new int[N + 1];
        for (int i = 1; i <= N; i++)
            table[i] = i;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.add(new Node(u, v, w));
        }
        int ans = 0;
        ans = kruskal(ans);
        System.out.println(ans);
    }

    private static int kruskal(int ans) {
        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (findParent(node.u) != findParent(node.v)) {
                union(node.u, node.v);
                ans += node.w;
            }
        }
        return ans;
    }

    private static int findParent(int a) {
        if (table[a] == a) return a;
        return table[a] = findParent(table[a]);
    }

    private static void union(int a, int b) {
        int p1 = findParent(a);
        int p2 = findParent(b);

        if (p1 != p2) {
            if (p1 < p2)
                table[p2] = p1;
            else
                table[p1] = p2;
        }
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