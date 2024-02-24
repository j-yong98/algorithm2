import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static int[] arr;
    static int[][] dp;
    static List<List<Integer>> friends = new ArrayList<>();
    static List<Integer> group = new ArrayList<>();
    static List<Integer> cnt = new ArrayList<>();
    static List<Integer> candy = new ArrayList<>();
    static boolean[] visited;

    /**
     * 할로윈의 양아치
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        visited = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i <= N; i++) {
            friends.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends.get(a).add(b);
            friends.get(b).add(a);
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                continue;
            }
            bfs(i);
        }

        int n = group.size();
        dp = new int[n][K];

        for (int i = 1; i < K; i++) {
            if (i - cnt.get(0) < 0) continue;
            dp[0][i] = candy.get(0);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < K; j++) {
                if (j - cnt.get(i) >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cnt.get(i)] + candy.get(i));
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[n - 1][K - 1]);
        br.close();
    }

    private static void bfs(int start) {
        Deque<Integer> q = new ArrayDeque<>();

        q.add(start);
        visited[start] = true;
        group.add(start);

        int c = 1;
        int totalCandy = arr[start];
        while (!q.isEmpty()) {
            Integer now = q.pollFirst();

            for (int friend : friends.get(now)) {
                if (visited[friend]) continue;
                visited[friend] = true;
                q.add(friend);
                c += 1;
                totalCandy += arr[friend];
            }
        }
        cnt.add(c);
        candy.add(totalCandy);
    }

}