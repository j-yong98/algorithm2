import java.util.*;
class Solution {
    final int[] dy = {-1,1,0,0};
    final int[] dx = {0,0,-1,1};
    
    int ans = Integer.MAX_VALUE;
    String[] arr;
    int N, M;
    int[] start;
    int[][] visited;
    public int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        arr = board;
        visited = new int[N][M];
        for (int i = 0; i < N; i++)
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i].charAt(j) == 'R') {
                    start = new int[]{i, j};
                    break;
                }
            }
            if (start != null) break;
        }
        dfs(start[0], start[1], 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    private void dfs(int y, int x, int move) {
        visited[y][x] = move;
        if (move >= ans) return;
        if (arr[y].charAt(x) == 'G') {
            ans = Math.min(ans, move);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int[] pos = go(y, x, i);
            if (visited[pos[0]][pos[1]] <= move + 1) continue;
            dfs(pos[0], pos[1], move + 1);
        }
    }
    
    private int[] go(int y, int x, int dir) {
        while (true) {
            int yy = y + dy[dir];
            int xx = x + dx[dir];
            if (!inRange(yy, xx) || arr[yy].charAt(xx) == 'D')
                return new int[]{y, x};
            y = yy;
            x = xx;
        }
    }
    
    private boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}