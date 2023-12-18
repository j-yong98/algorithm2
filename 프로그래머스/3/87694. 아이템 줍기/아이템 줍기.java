import java.util.*;
class Solution {
    final int N = 100;
    final int[] dy = {-1, 1, 0, 0};
    final int[] dx = {0, 0, -1, 1};
    
    int[][] arr = new int[N + 1][N + 1];
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for (int[] r : rectangle) {
            fill(r[0] * 2, r[1] * 2, r[2] * 2, r[3] * 2);
        }
        return bfs(new int[]{characterY * 2, characterX * 2}, new int[]{itemY * 2, itemX * 2});
    }
    
    private void fill(int x1, int y1, int x2, int y2) {
        for (int i = y1; i <= y2; i++) {
            for (int j = x1; j <= x2; j++) {
                if (arr[i][j] == 2) continue;
                arr[i][j] = 2;
                if (i == y1 || i == y2 || j == x1 || j == x2) {
                    arr[i][j] = 1;
                }
            }
        }
    }
    
    private int bfs(int[] start, int[] goal) {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N + 1][N + 1];
        
        q.add(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        
        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();
            
            if (pos[0] == goal[0] && pos[1] == goal[1]) {
                return pos[2] >> 1;
            }
            for (int i = 0; i < 4; i++) {
                int y = pos[0] + dy[i];
                int x = pos[1] + dx[i];
                if (!inRange(y, x) || visited[y][x] || arr[y][x] != 1) continue;
                q.add(new int[]{y, x, pos[2] + 1});
                visited[y][x] = true;
            }
        }
        return -1;
    }
    
    private boolean inRange(int y, int x) {
        return y >= 0 && y <= N && x >= 0 && x <= N;
    }
    
    private void printMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}