import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<List<Integer>> edges = new ArrayList<>();
    static int[] answer;
    static int[] pre;
    static boolean find = false;
    static boolean[] visited;
    static boolean[] cycle;

    /**
     * 서울 지하철 2호선
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pre = new int[N + 1];
        answer = new int[N + 1];
        visited = new boolean[N + 1];
        cycle = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges.get(u).add(v);
            edges.get(v).add(u);
        }
        findCycle(1);
        bfs();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
        br.close();
    }

    private static void findCycle(int now) {
        visited[now] = true;
        for (int next : edges.get(now)) {
            if (find) return;
            if (visited[next]) {
                if (next != pre[now]) {
                    cycle[now] = true;
                    find = true;
                    while (now != next) {
                        cycle[pre[now]] = true;
                        now = pre[now];
                    }
                }
            } else {
                pre[next] = now;
                findCycle(next);
            }
        }
    }

    private static void bfs() {
        Deque<Integer> q = new ArrayDeque<>();
        Arrays.fill(visited, false);

        for (int i = 1; i <= N; i++) {
            if (!cycle[i]) continue;
            q.add(i);
            visited[i] = true;
        }

        while (!q.isEmpty()) {
            int now = q.pollFirst();

            for (int next : edges.get(now)) {
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                answer[next] = answer[now] + 1;
                q.add(next);
            }
        }
    }
}