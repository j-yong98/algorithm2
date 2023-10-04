import java.util.*;
class Solution {
    final char OBSTACLE = 'X';
    
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, -1, 1};
    
    Map<Character, Integer> dir = new HashMap<>();
    int N, M;
    int[] pos;
    
    public int[] solution(String[] park, String[] routes) {
        init(park);
        for (int i = 0; i < routes.length; i++) {
            StringTokenizer st = new StringTokenizer(routes[i]);
            int d = dir.get(st.nextToken().charAt(0));
            int r = Integer.parseInt(st.nextToken());
            if (!move(d, r, park)) continue;
            pos[0] = (pos[0] + dy[d] * r);
            pos[1] = (pos[1] + dx[d] * r);
        }
        return pos;
    }
    
    private boolean move(int d, int r, String[] arr) {
        int yy = pos[0];
        int xx = pos[1];
        for (int i = 0; i < r; i++) {
            int y = yy + dy[d];
            int x = xx + dx[d];
            if (!inRange(y, x) || arr[y].charAt(x) == OBSTACLE)
                return false;
            yy = y;
            xx = x;
        }
        return true;
    }
    
    private void init(String[] map) {
        N = map.length;
        M = map[0].length();
        dir.put('N', 0);
        dir.put('S', 1);
        dir.put('W', 2);
        dir.put('E', 3);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i].charAt(j) == 'S') {
                    pos = new int[]{i, j};
                    return;
                }
            }
        }
    }
    
    private boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}