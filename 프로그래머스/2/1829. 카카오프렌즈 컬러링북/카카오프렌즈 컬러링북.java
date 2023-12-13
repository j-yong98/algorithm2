import java.util.*;
class Solution {
    final int[] dy = {-1,1,0,0};
    final int[] dx = {0,0,-1,1};
    int N, M;
    int[][] arr;
    boolean[][] visited;
    int numOfArea = 0;
    int maxOfArea = 0;
    public int[] solution(int m, int n, int[][] picture) {
        arr = picture;
        N = m;
        M = n;
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] || arr[i][j] == 0) continue;
                numOfArea += 1;
                int result = bfs(i, j);
                maxOfArea = Math.max(maxOfArea, result);
            }
        }
        return new int[]{numOfArea, maxOfArea};
    }
    
    public int bfs(int y, int x) {
        Deque<int[]> q = new ArrayDeque<>();
        
        int cnt = 1;
        visited[y][x] = true;
        q.add(new int[]{y, x});
        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();
            
            for (int i = 0; i < 4; i++) {
                int yy = pos[0] + dy[i];
                int xx = pos[1] + dx[i];
                if (!inRange(yy, xx) || visited[yy][xx] || arr[yy][xx] != arr[y][x]) continue;
                visited[yy][xx] = true;
                q.add(new int[]{yy, xx});
                cnt += 1;
            }
        }
        return cnt;
    }
    
    private boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}