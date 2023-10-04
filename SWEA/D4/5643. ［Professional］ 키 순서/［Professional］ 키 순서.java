import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static final int MAX = 1_000_000_000;
    static int T;
    static int N, M;
    static List<List<Integer>> edges;
    static int[][] dist;
    /**
     * 키 순서
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            edges = new ArrayList<>();
            dist = new int[N + 1][N + 1];
            for (int i = 0; i <= N; i++)
                edges.add(new ArrayList<>());
            for (int i = 1; i <= N; i++)
                Arrays.fill(dist[i], MAX);
            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                edges.get(a).add(b);
                dist[a][b] = 1;
            }

            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++)
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
            int ans = 0;
            for (int i = 1; i <= N; i++) {
                int cnt = 0;
                for (int j = 1; j <= N; j++) {
                    if (i == j || dist[i][j] == MAX) continue;
                    cnt++;
                }

                for (int j = 1; j <= N; j++) {
                    if (i == j || dist[j][i] == MAX) continue;
                    cnt++;
                }
                if (cnt == N - 1)
                    ans++;
            }
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}