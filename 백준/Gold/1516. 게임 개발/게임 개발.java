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
    static int[] time;
    static int[] indegree;
    static int[] ans;
    static List<List<Integer>> edges = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        time = new int[N + 1];
        ans = new int[N + 1];
        indegree = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == -1) {
                    break;
                }
                if (j == 0) {
                    time[i] = val;
                } else {
                    edges.get(val).add(i);
                    indegree[i]++;
                }
            }
        }

        int cnt = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] != 0) {
                continue;
            }
            ans[i] = time[i];
            q.addLast(i);
            cnt += 1;
        }

        while (!q.isEmpty() && cnt < N) {
            int now = q.pollFirst();

            for (int next : edges.get(now)) {
                ans[next] = Math.max(ans[next], ans[now]);
                if (--indegree[next] == 0) {
                    ans[next] += time[next];
                    q.add(next);
                    cnt += 1;
                }
            }
        }

        Arrays.stream(ans, 1, N + 1).forEach(System.out::println);
    }
}