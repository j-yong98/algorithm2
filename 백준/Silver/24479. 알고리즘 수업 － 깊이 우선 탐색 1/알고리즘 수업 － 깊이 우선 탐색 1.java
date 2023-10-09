import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, R;
    static List<List<Integer>> edges = new ArrayList<>();
    static int[] arr;
    static boolean[] visited;
    static int id;
    /**
     * 알고리즘 수업 - 깊이 우선 탐색
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++)
            edges.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges.get(u).add(v);
            edges.get(v).add(u);
        }
        for (int i = 1; i <= N; i++)
            Collections.sort(edges.get(i));
        dfs(R);
        Arrays.stream(arr, 1, N + 1).forEach(System.out::println);
        br.close();
    }

    private static void dfs(int now) {
        arr[now] = ++id;
        visited[now] = true;
        for (int next : edges.get(now)) {
            if (visited[next]) continue;
            dfs(next);
        }
    }
}