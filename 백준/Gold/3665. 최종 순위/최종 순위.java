import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int T, N, M;
    static int[] rank;
    static int[] indegree;
    static boolean[][] edges;
    /**
     * 최종 순위
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            rank = new int[N];
            indegree = new int[N + 1];
            edges = new boolean[N + 1][N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                rank[i] = Integer.parseInt(st.nextToken());
                for (int j = 0; j < i; j++) {
                    indegree[rank[j]] += 1;
                    edges[rank[i]][rank[j]] = true;
                }
            }
            M = Integer.parseInt(br.readLine());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (edges[a][b]) {
                    indegree[b] -= 1;
                    indegree[a] += 1;
                    edges[a][b] = false;
                    edges[b][a] = true;
                } else if (edges[b][a]) {
                    indegree[b] += 1;
                    indegree[a] -= 1;
                    edges[a][b] = true;
                    edges[b][a] = false;
                }
            }
            sb.append(topologicalSorting()).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    private static String topologicalSorting() {
        Deque<Integer> q = new ArrayDeque<>();
        Stack<Integer> result = new Stack<>();
        int cnt = 0;
        boolean flag = false;

        for (int i = 1; i <= N; i++) {
            if (indegree[i] != 0) continue;
            cnt += 1;
            q.add(i);
        }

        while (!q.isEmpty()) {
            int now = q.pollFirst();
            result.add(now);
            if (q.size() > 1) {
                flag = true;
            }

            for (int i = 1; i <= N; i++) {
                if (!edges[now][i]) continue;
                if (--indegree[i] == 0) {
                    q.add(i);
                    cnt += 1;
                }
            }
        }

        if (cnt != N) {
            return "IMPOSSIBLE";
        }
        StringBuilder sb = new StringBuilder();
        while (!result.isEmpty()) {
            sb.append(result.pop()).append(" ");
        }
        return sb.toString();
    }
}