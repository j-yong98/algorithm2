import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        for (int i = 0; i < routes.length; i++) {
            pq.add(routes[i]);
        }
        
        int last = pq.poll()[1];
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            
            if (last < now[0]) {
                answer++;
                last = now[1];
            } else {
                last = Math.min(last, now[1]);
            }
        }
        return answer;
    }
}