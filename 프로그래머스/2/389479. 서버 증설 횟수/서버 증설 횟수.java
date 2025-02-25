import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        int server = 0;
        int cnt = 0;
        for (int i = 0; i < players.length; i++) {
            int users = players[i];
            while (!pq.isEmpty() && pq.peek()[1] < i) {
                server -= pq.poll()[0];
            }
            
            int need = Math.max(0, (users / m) - server);
            if (need > 0) {
                pq.add(new int[]{need, i + k - 1});
                cnt += need;
                server += need;
            }
        }
        return cnt;
    }
}