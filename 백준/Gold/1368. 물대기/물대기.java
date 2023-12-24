import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<List<Node>> edges = new ArrayList<>();

    /**
     * 물대기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 1; i <= N; i++) {
            int w = Integer.parseInt(br.readLine());
            edges.get(0).add(new Node(i, w));
        }
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if (i == j) {
                    continue;
                }
                edges.get(i).add(new Node(j, cost));
            }
        }

        long res = prim();
        System.out.println(res);

        br.close();
    }

    private static long prim() {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.w, b.w));
        boolean[] visited = new boolean[N + 1];
        int cnt = 1;
        long weight = 0;
        for (int i = 0; i < N; i++) {
            if (edges.get(i).isEmpty()) {
                continue;
            }
            visited[i] = true;
            pq.addAll(edges.get(i));
            break;
        }

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.v]) {
                continue;
            }

            visited[now.v] = true;
            cnt += 1;
            weight += now.w;
            for (Node next : edges.get(now.v)) {
                if (visited[next.v]) {
                    continue;
                }
                pq.add(next);
            }
        }
        return weight;
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