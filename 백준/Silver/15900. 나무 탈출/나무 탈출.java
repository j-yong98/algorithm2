import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static List<Integer>[] edges;
    static boolean[] visited;
    static int leafLevel;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        edges = new List[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }

        makeTree(1, 0);
        System.out.println(leafLevel % 2 != 0 ? "Yes" : "No");
    }

    private static void makeTree(int now, int level) {
        visited[now] = true;
        int cnt = 0;
        for (int next : edges[now]) {
            if (visited[next]) continue;
            makeTree(next, level + 1);
            cnt++;
        }

        if (isLeaf(cnt)) {
            leafLevel += level;
        }
    }

    private static boolean isLeaf(int cnt) {
        return cnt == 0;
    }
}

