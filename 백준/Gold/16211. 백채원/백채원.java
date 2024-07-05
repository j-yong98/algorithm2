import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static List<List<Node>> edges = new ArrayList<>();
    static boolean[] kArr;

    /**
     * 백채원
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        kArr = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            edges.get(a).add(new Node(b, t));
            edges.get(b).add(new Node(a, t));
        }

        int[][] dist = new int[2][N + 1];
        for (int i = 0; i < 2; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.w, b.w));
        pq.add(new Node(1, 0, 0));
        dist[0][1] = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int u = Integer.parseInt(st.nextToken());
            pq.add(new Node(u, 0, 1));
            dist[1][u] = 0;
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (now.w > dist[now.flag][now.v]) {
                continue;
            }

            for (Node next : edges.get(now.v)) {
                if (kArr[next.v] || now.w + next.w >= dist[now.flag][next.v]) {
                    continue;
                }
                dist[now.flag][next.v] = now.w + next.w;
                pq.add(new Node(next.v, dist[now.flag][next.v], now.flag));
            }
        }
        for (int i = 2; i <= N; i++) {
            if (dist[0][i] < dist[1][i]) {
                sb.append(i).append(" ");
            }
        }
        if (sb.length() == 0) {
            System.out.println(0);
        } else {
            System.out.println(sb);
        }
        br.close();
    }

    static class Node {
        int v;
        int w;
        int flag;

        public Node(int v, int w, int flag) {
            this.v = v;
            this.w = w;
            this.flag = flag;
        }

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
            this.flag = -1;
        }
    }
}