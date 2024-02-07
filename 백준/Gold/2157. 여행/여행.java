import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 300;
    static int N, M, K;
    static List<List<Node>> edges = new ArrayList<>();
    static int[][] dp = new int[MAX + 1][MAX + 1];

    /**
     * 여행
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.get(u).add(new Node(v, cost));
        }
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(getAnswer(1, 1));
    }

    private static int getAnswer(int now, int cnt) {
        if (dp[now][cnt] != -1) return dp[now][cnt];

        if (now == N) {
            return 0;
        }

        if (cnt >= M) {
            return Integer.MIN_VALUE;
        }

        dp[now][cnt] = Integer.MIN_VALUE;
        for (Node next : edges.get(now)) {
            if (now > next.v) continue;
            dp[now][cnt] = Math.max(dp[now][cnt], next.w + getAnswer(next.v, cnt + 1));
        }
        return dp[now][cnt];
    }

    static class Node {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}