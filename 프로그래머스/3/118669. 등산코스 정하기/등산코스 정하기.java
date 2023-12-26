import java.util.*;
class Solution {
    List<List<Node>> edges = new ArrayList<>();
    boolean[] isGate;
    boolean[] isSummit;
    int[] dp;
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        isGate = new boolean[n + 1];
        isSummit = new boolean[n + 1];
        Arrays.sort(summits);
        dp = new int[summits.length];
        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] path : paths) {
            edges.get(path[0]).add(new Node(path[1], path[2]));
            edges.get(path[1]).add(new Node(path[0], path[2]));
        }
        for (int gate : gates) {
            isGate[gate] = true;
        }
        for (int summit : summits) {
            isSummit[summit] = true;
        }
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int gate : gates) {
            int[] intensity = dijkstra(n, gate);
            for (int i = 0; i < summits.length; i++) {
                dp[i] = Math.min(dp[i], intensity[summits[i]]);
            }
        }
        int[] answer = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        for (int i = 0; i < summits.length; i++) {
            if (answer[1] > dp[i]) {
                answer[0] = summits[i];
                answer[1] = dp[i];
            }
        }
        return answer;
    }
    
    private int[] dijkstra(int n, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.w, b.w));
        int[] dist = new int[n + 1];
        int[] intensity = new int[n + 1];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(intensity, Integer.MAX_VALUE);
        dist[start] = 0;
        intensity[start] = 0;
        pq.add(new Node(start, 0));
        
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            
            if (isSummit[now.v]) break;
            for (Node next : edges.get(now.v)) {
                if (isGate[next.v] || next.w >= dist[next.v]) continue;
                dist[next.v] = next.w;
                intensity[next.v] = Math.max(intensity[now.v], dist[next.v]);
                pq.add(next);
            }
        }
        
        return intensity;
    }
    
    static class Node {
        int v;
        int w;
        
        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node) o;
            return this.v == node.v && this.w == node.w;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(v, w);
        }
    }
}