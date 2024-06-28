import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int A, B;
    static boolean[] visited;
    static List<List<Node>> edges = new ArrayList<>();
    /**
     * 두 로봇
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.get(u).add(new Node(v, w));
            edges.get(v).add(new Node(u, w));
        }
        Deque<int[]> q = new ArrayDeque<>();
        visited[A] = true;
        q.add(new int[]{A, 0, 0});
        while (!q.isEmpty()) {
            int[] now = q.pollFirst();

            if (now[0] == B) {
                System.out.println(now[1] - now[2]);
                break;
            }

            for (Node next : edges.get(now[0])) {
                if (visited[next.v]) {
                    continue;
                }
                visited[next.v] = true;
                q.add(new int[]{next.v, now[1] + next.w, Math.max(now[2], next.w)});
            }
        }
        br.close();
    }

    private static class Node {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}