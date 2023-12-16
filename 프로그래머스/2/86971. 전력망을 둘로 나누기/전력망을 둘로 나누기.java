import java.util.*;
class Solution {
    int N;
    boolean[][] connected;
    List<Integer> teamA = new ArrayList<>();
    int ans;
    public int solution(int n, int[][] wires) {
        N = n;
        connected = new boolean[N + 1][N + 1];
        for (int[] wire : wires) {
            connected[wire[0]][wire[1]] = true;
            connected[wire[1]][wire[0]] = true;
        }
        ans = N;
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (!connected[i][j]) continue;
                connected[i][j] = false;
                connected[j][i] = false;
                ans = Math.min(ans, calc());
                connected[i][j] = true;
                connected[j][i] = true;
            }
        }
        return ans;
    }
    
    private int calc() {
        int teamA = 0;
        Deque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        
        q.add(1);
        while (!q.isEmpty()) {
            int now = q.pollFirst();
            
            for (int i = 1; i <= N; i++) {
                if (!connected[now][i] || visited[i]) continue;
                visited[i] = true;
                q.add(i);
                teamA += 1;
            }
        }
        int teamB = N - teamA;
        return Math.abs(teamA - teamB);
    }
}