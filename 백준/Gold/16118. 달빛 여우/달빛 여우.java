import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static List<List<Node>> edges = new ArrayList<>();
    static long[] foxDist;
    static long[][] wolfDist;
    static PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Long.compare(a.w, b.w));


    /**
     * 달빛 여우
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
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
        fox();
        wolf();
        int cnt = 0;
        for (int i = 2; i <= N; i++) {
            if (foxDist[i] < Math.min(wolfDist[0][i], wolfDist[1][i]))
                cnt++;
        }
        System.out.println(cnt);
        br.close();
    }

    private static void fox() {
        foxDist = new long[N + 1];
        Arrays.fill(foxDist, Long.MAX_VALUE);

        pq.add(new Node(1, 0));
        foxDist[1] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.w > foxDist[now.v]) continue;

            for (Node next : edges.get(now.v)) {
                if (foxDist[next.v] <= foxDist[now.v] + next.w * 2) continue;
                foxDist[next.v] = foxDist[now.v] + next.w * 2;
                pq.add(new Node(next.v, foxDist[next.v]));
            }
        }
    }

    private static void wolf() {
        wolfDist = new long[2][N + 1];
        for (int i = 0; i < 2; i++)
            Arrays.fill(wolfDist[i], Long.MAX_VALUE);

        pq.add(new Node(1, 0, 0));
        wolfDist[0][1] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.w > wolfDist[now.flag][now.v]) continue;

            for (Node next : edges.get(now.v)) {
                long nextD = now.flag == 0 ? next.w : next.w * 4;
                if (wolfDist[now.flag ^ 1][next.v] <= wolfDist[now.flag][now.v] + nextD) continue;
                wolfDist[now.flag ^ 1][next.v] = wolfDist[now.flag][now.v] + nextD;
                pq.add(new Node(next.v, wolfDist[now.flag ^ 1][next.v], now.flag ^ 1));
            }
        }
    }

    static class Node {
        int v;
        long w;
        int flag;

        public Node(int v, long w) {
            this.v = v;
            this.w = w;
        }

        public Node(int v, long w, int flag) {
            this.v = v;
            this.w = w;
            this.flag = flag;
        }
    }
}