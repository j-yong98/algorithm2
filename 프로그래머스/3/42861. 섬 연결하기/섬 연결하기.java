import java.util.*;
class Solution {
    int[] parent;
    PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
    public int solution(int n, int[][] costs) {
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < costs.length; i++) {
            for (int j = 0; j < costs[i].length; j++) {
                int u = costs[i][0];
                int v = costs[i][1];
                int cost = costs[i][2];
                pq.add(new Node(u, v, cost));
            }
        }
        
        int w = 0;
        int visited = 0;
        while (!pq.isEmpty() && visited < n - 1) {
            Node now = pq.poll();
            if (findParent(now.u) != findParent(now.v)) {
                union(now.u, now.v);
                w += now.cost;
                visited++;
            }
        }
        return w;
    }
    
    private void union(int a, int b) {
        int p1 = findParent(a);
        int p2 = findParent(b);
        
        if (p1 != p2) {
            parent[p2] = p1;
        }
    }
    
    private int findParent(int a) {
        if (parent[a] == a) return a;
        return parent[a] = findParent(parent[a]);
    }
    
    static class Node {
        int u;
        int v;
        int cost;
        
        public Node(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
    }
}