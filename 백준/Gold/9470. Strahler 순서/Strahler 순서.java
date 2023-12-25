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
    static int T;
    static int K, M, P;
    static int[] cnt;
    static int[] answer;
    static boolean[] checked;
    static List<List<Integer>> edges;
    /**
     * Strahler 순서
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            cnt = new int[M + 1];
            answer = new int[M + 1];
            checked = new boolean[M + 1];
            edges = new ArrayList<>();
            for (int i = 0; i <= M; i++) {
                edges.add(new ArrayList<>());
            }
            for (int i = 0; i < P; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                cnt[v] += 1;
                edges.get(u).add(v);
            }
            Deque<Integer> q = new ArrayDeque<>();
            for (int i = 1; i <= M; i++) {
                if (cnt[i] == 0) {
                    answer[i] = 1;
                    q.add(i);
                }
            }
            while (!q.isEmpty()) {
                int now = q.pollFirst();

                for (int next : edges.get(now)) {
                    if (answer[now] > answer[next]) {
                        answer[next] = answer[now];
                        checked[next] = false;
                    } else if (answer[now] == answer[next] && !checked[next]) {
                        checked[next] = true;
                        answer[next] += 1;
                    }
                    if (--cnt[next] == 0) {
                        q.add(next);
                    }
                }
            }
            sb.append(K).append(" ").append(Arrays.stream(answer).max().getAsInt()).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}