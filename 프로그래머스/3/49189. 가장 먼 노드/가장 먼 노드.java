import java.util.*;
class Solution {
    int[] parent;
    List<List<Integer>> edges = new ArrayList<>();
    public int solution(int n, int[][] edge) {
        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] e : edge) {
            edges.get(e[0]).add(e[1]);
            edges.get(e[1]).add(e[0]);
        }
        
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        
        Deque<Integer> q = new ArrayDeque<>();
        int[] dist = new int[n + 1];
        
        q.add(1);
        while (!q.isEmpty()) {
            int now = q.pollFirst();
            
            for (int next : edges.get(now)) {
                if (findParent(now) != findParent(next)) {
                    union(now, next);
                    dist[next] = dist[now] + 1;
                    q.add(next);
                }
            }
        }
        int max = Arrays.stream(dist).max().getAsInt();
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (max == dist[i]) {
                cnt += 1;
            }
        }
        return cnt;
    }
    
    private int findParent(int a) {
        if (a == parent[a]) return a;
        return parent[a] = findParent(parent[a]);
    }
    private void union(int a, int b) {
        int p1 = findParent(a);
        int p2 = findParent(b);
        
        if (p1 != p2) {
            parent[p2] = p1;
        }
    }
}