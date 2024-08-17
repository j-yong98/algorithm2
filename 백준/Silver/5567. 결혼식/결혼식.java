import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static List<List<Integer>> edges = new ArrayList<>();
    /**
     * 결혼식
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges.get(a).add(b);
            edges.get(b).add(a);
        }
        boolean[] visited = new boolean[N + 1];
        Deque<int[]> q = new ArrayDeque<>();
        visited[1] = true;
        q.add(new int[]{1, 0});
        int cnt = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[1] == 2) {
                continue;
            }

            for (int next : edges.get(now[0])) {
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                cnt++;
                q.add(new int[]{next, now[1] + 1});
            }
        }
        System.out.println(cnt);
        br.close();
    }
}