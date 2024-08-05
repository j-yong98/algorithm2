import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static List<Node> edges = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Node(u, v, w));
        }

        long[] dist = new long[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Node now = edges.get(j);
                if (dist[now.u] != Integer.MAX_VALUE && dist[now.v] > dist[now.u] + now.w) {
                    dist[now.v] = dist[now.u] + now.w;
                }
            }
        }
        for (int i = 0; i < M; i++) {
            Node now = edges.get(i);
            if (dist[now.v] == Integer.MAX_VALUE) continue;
            if (dist[now.v] > dist[now.u] + now.w) {
                System.out.println(-1);
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
            sb.append(dist[i]).append("\n");
        }
        System.out.print(sb);
    }

    static class Node {
        int u;
        int v;
        long w;

        public Node(int u, int v, long w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
}