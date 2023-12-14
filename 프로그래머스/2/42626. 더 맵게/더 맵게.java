import java.util.*;
class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int solution(int[] scoville, int K) {
        for (int s : scoville) {
            pq.add(s);
        }
        
        int answer = 0;
        while (pq.size() >= 2 && pq.peek() < K) {
            answer += 1;
            int first = pq.poll();
            int second = pq.poll();
            
            int newScoville = first + (second * 2);
            pq.add(newScoville);
        }
        if (pq.peek() < K) return -1;
        return answer;
    }
}