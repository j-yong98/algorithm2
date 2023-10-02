import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V, E;
    static List<Integer>[] edges;
    static PriorityQueue<List<Integer>> SCC;
    static boolean[] isFinish;
    static Deque<Integer> s = new ArrayDeque<>();
    static int id = 0;
    static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        edges = new List[V + 1];
        isFinish = new boolean[V + 1];
        d = new int[V + 1];
        SCC = new PriorityQueue<>((a, b) -> a.get(0) > b.get(0) ? 1 : -1);
        for (int i = 0; i <= V; i++)
            edges[i] = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
        }
        for (int i = 1; i <= V; i++) {
            if (isFinish[i]) continue;
            dfs(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SCC.size()).append("\n");
        while (!SCC.isEmpty()) {
            List<Integer> scc = SCC.poll();
            for (int c : scc)
                sb.append(c).append(" ");
            sb.append("-1\n");
        }
        System.out.println(sb);
    }

    private static int dfs(int now) {
        d[now] = ++id;
        s.push(now);

        int parent = d[now];
        for (int next : edges[now]) {
            if (d[next] == 0) parent = Math.min(parent, dfs(next));
            else if (!isFinish[next]) parent = Math.min(parent, d[next]);
        }

        if (parent == d[now]) {
            List<Integer> scc = new ArrayList<>();
            while (true) {
                int top = s.pop();
                scc.add(top);
                isFinish[top] = true;
                if (top == now) break;
            }
            Collections.sort(scc);
            SCC.add(scc);
        }
        return parent;
    }
}