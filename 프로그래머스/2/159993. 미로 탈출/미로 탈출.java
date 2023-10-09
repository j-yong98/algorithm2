import java.util.*;
class Solution {
    final int[] dy = {-1, 1, 0, 0};
    final int[] dx = {0, 0, -1, 1};
    final char WALL = 'X';
    final char PATH = 'O';
    int N, M;
    char[][] arr;
    int[] start;
    int[] exit;
    int[] lever;
    public int solution(String[] maps) {
        arr = new char[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++)
            arr[i] = maps[i].toCharArray();
        N = maps.length;
        M = maps[0].length();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 'S') {
                    start = new int[]{i, j};
                    arr[i][j] = PATH;
                } else if (arr[i][j] == 'L') {
                    lever = new int[]{i, j};
                    arr[i][j] = PATH;
                } else if (arr[i][j] == 'E') {
                    exit = new int[]{i, j};
                    arr[i][j] = PATH;
                }
            }
        }
        int res = bfs(start, lever);
        if (res == -1)
            return -1;
        int tmp = bfs(lever, exit);
        if (tmp == -1)
            return -1;
        return res + tmp;
    }
    
    private int bfs(int[] target, int[] goal) {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        
        q.add(new int[]{target[0], target[1], 0});
        visited[target[0]][target[1]] = true;
        
        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();
            
            if (pos[0] == goal[0] && pos[1] == goal[1])
                return pos[2];
            
            for (int i = 0; i < 4; i++) {
                int y = pos[0] + dy[i];
                int x = pos[1] + dx[i];
                if (!inRange(y, x) || arr[y][x] == WALL || visited[y][x]) continue;
                visited[y][x] = true;
                q.add(new int[]{y, x, pos[2] + 1});
            }
        }
        return -1;
    }
    
    private boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}