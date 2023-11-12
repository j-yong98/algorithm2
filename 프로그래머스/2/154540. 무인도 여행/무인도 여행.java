import java.util.*;
class Solution {
    final int[] dy = {-1, 1, 0, 0};
    final int[] dx = {0, 0, -1, 1};
    
    int N, M;
    boolean[][] visited;
    String[] arr;
    List<Integer> ans = new ArrayList<>();
    public int[] solution(String[] maps) {
        arr = maps;
        N = maps.length;
        M = maps[0].length();
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] || arr[i].charAt(j) == 'X') continue;
                ans.add(bfs(i, j));
            }
        }
        if (ans.isEmpty())
            return new int[]{-1};
        Collections.sort(ans);
        return ans.stream().mapToInt(i -> i).toArray();
    }
    
    private int bfs(int y, int x) {
        Deque<int[]> q = new ArrayDeque<>();
        
        q.addLast(new int[]{y, x});
        visited[y][x] = true;
        
        int sum = toDigit(arr[y].charAt(x));        
        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();
            
            for (int i = 0; i < 4; i++) {
                int yy = pos[0] + dy[i];
                int xx = pos[1] + dx[i];
                if (!inRange(yy, xx) || visited[yy][xx] || arr[yy].charAt(xx) == 'X') continue;
                visited[yy][xx] = true;
                q.addLast(new int[]{yy, xx});
                sum += toDigit(arr[yy].charAt(xx));
            }
        }
        return sum;
    }
    
    private boolean inRange(int y,int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
    
    private int toDigit(char c) {
        return c - '0';
    }
}