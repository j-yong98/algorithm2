import java.util.*;
class Solution {
    int N, X;
    int cnt;
    final int[] dy = {-1, 1, 0, 0};
    final int[] dx = {0, 0, -1, 1};
    final int MAX = 1000000;
    List<List<int[]>> list = new ArrayList<>();
    public int solution(int[][] points, int[][] routes) {
        N = points.length;
        X = routes.length;
        for (int i = 0; i < MAX; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < X; i++) {
            cnt = 0;
            for (int j = 1; j < routes[i].length; j++) {
                int from = routes[i][j - 1] - 1;
                int to = routes[i][j] - 1;
                findPath(points[from], points[to]);
            }
        }

        int ans = 0;
        for (List<int[]> l : list) {
            Map<String, Integer> map = new HashMap<>();
            for (int[] pos : l) {
                String str = pos[0] + "," + pos[1];
                map.put(str, map.getOrDefault(str, 0) + 1);
            }

            for (int v : map.values()) {
                if (v > 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private void findPath(int[] from, int[] to) {
        int[] temp = new int[]{from[0], from[1]};
        if (cnt == 0) {
            list.get(cnt).add(new int[]{temp[0], temp[1]});
        }
        while (temp[0] != to[0] || temp[1] != to[1]) {
            int d = getDir(temp, to);
            temp[0] = temp[0] + dy[d];
            temp[1] = temp[1] + dx[d];
            list.get(++cnt).add(new int[]{temp[0], temp[1]});
        }
    }

    private int getDir(int[] from, int[] to) {
        if (from[0] != to[0]) {
            return from[0] > to[0] ? 0 : 1;
        }
        return from[1] > to[1] ? 2 : 3;
    }
}