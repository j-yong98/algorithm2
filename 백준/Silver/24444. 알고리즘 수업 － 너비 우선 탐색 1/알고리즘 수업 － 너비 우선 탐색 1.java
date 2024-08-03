import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R;
    static List<List<Integer>> edges = new ArrayList<>();
    /**
     * 알고리즘 수업 - 너비 우선 탐색 1
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges.get(u).add(v);
            edges.get(v).add(u);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(edges.get(i));
        }

        int cnt = 1;
        Deque<Integer> q = new ArrayDeque<>();
        int[] visited = new int[N + 1];
        q.add(R);
        visited[R] = cnt++;
        while (!q.isEmpty()) {
            int now = q.pollFirst();

            for (int next : edges.get(now)) {
                if (visited[next] != 0) continue;
                visited[next] = cnt++;
                q.add(next);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}