import java.util.*;
class Solution {
    final int MAX = 1_000_000_000;
    int[][] dist;
    public int solution(int n, int[][] results) {
        dist = new int[n + 1][n + 1];
        for (int i = 1; i <=n; i++) {
            Arrays.fill(dist[i], MAX);
        }
        for (int[] edge : results) {
            dist[edge[0]][edge[1]] = 1;
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (i == j || dist[i][j] == MAX) continue;
                cnt++;
            }
            for (int j = 1; j <= n; j++) {
                if (i == j || dist[j][i] == MAX) continue;
                cnt++;
            }
            if (cnt == n - 1) {
                answer++;
            }
        }
        return answer;
    }
}