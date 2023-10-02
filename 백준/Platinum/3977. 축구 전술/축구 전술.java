import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T;
    static int N, M;
    static int[] s;
    static int id;
    static boolean[] isFinish;
    static int[] sccArr;
    static int sccCnt;
    static List<List<Integer>> edges;
    static Stack<Integer> stack = new Stack<>();
    static int[] indegree;
    /**
     * 축구 전술
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            if (t != 1)
                br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            id = 0;
            s = new int[N];
            sccCnt = 0;
            sccArr = new int[N];
            isFinish = new boolean[N];
            edges = new ArrayList<>();
            Arrays.fill(s, -1);
            for (int i = 0; i < N; i++)
                edges.add(new ArrayList<>());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                edges.get(a).add(b);
            }
            for (int i = 0; i < N; i++) {
                if (isFinish[i]) continue;
                dfs(i);
            }

            indegree = new int[sccCnt];
            for (int i = 0; i < N; i++) {
                for (int next : edges.get(i)) {
                    if (sccArr[i] != sccArr[next])
                        indegree[sccArr[next]]++;
                }
            }

            int count = 0;
            int start = -1;
            for (int i = 0; i < sccCnt; i++) {
                if (indegree[i] == 0) {
                    count++;
                    start = i;
                }
            }

            if (count > 1) sb.append("Confused\n");
            else {
                for (int i = 0; i < N; i++) {
                    if (sccArr[i] == start)
                        sb.append(i).append("\n");
                }
            }
            if (t != T)
                sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    private static int dfs(int now) {
        s[now] = id++;
        stack.push(now);

        int parent = s[now];
        for (int next : edges.get(now)) {
            if (s[next] == -1) parent = Math.min(parent, dfs(next));
            else if (!isFinish[next]) parent = Math.min(parent, s[next]);
        }

        if (parent == s[now]) {
            while (true) {
                int top = stack.pop();
                isFinish[top] = true;
                sccArr[top] = sccCnt;
                if (top == now) break;
            }
            sccCnt += 1;
        }
        return parent;
    }
}