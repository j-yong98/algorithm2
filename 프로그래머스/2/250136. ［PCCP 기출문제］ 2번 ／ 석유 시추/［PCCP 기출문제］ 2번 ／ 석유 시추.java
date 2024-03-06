import java.util.*;
class Solution {
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, -1, 1};
    int N;
    int M;
    int[] arr;
    boolean[][] visited;
    List<Integer> size = new ArrayList<>();
    public int solution(int[][] land) {
        N = land.length;
        M = land[0].length;
        visited = new boolean[N][M];
        size.add(0);
        int idx = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] || land[i][j] == 0) {
                    continue;
                }
                size.add(bfs(idx++, i, j, land));
            }
        }
        int ans = 0;
        for (int i = 0; i < M; i++) {
            int a = 0;
            boolean[] checked = new boolean[size.size() + 1];
            for (int j = 0; j < N; j++) {
                if (land[j][i] == 0 || checked[land[j][i]]) {
                    continue;
                }
                a += size.get(land[j][i]);
                checked[land[j][i]] = true;
            }
            ans = Math.max(ans, a);
        }
        return ans;
    }
    
    private int bfs(int idx, int y, int x, int[][] land) {
        Deque<int[]> q = new ArrayDeque<>();
        visited[y][x] = true;
        q.add(new int[]{y, x});
        land[y][x] = idx;
        int result = 1;
        
        while (!q.isEmpty()) {
            int[] now = q.pollFirst();
            
            for (int i = 0; i < 4; i++) {
                int yy = now[0] + dy[i];
                int xx = now[1] + dx[i];
                if (!inRange(yy, xx) || visited[yy][xx] || land[yy][xx] == 0) {
                    continue;
                }
                visited[yy][xx] = true;
                land[yy][xx] = idx;
                q.addLast(new int[]{yy, xx});
                result++;
            }
        }
        return result;
    }
    
    private boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}