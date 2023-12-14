import java.util.*;
class Solution {
//     int N;
//     int answer;
//     PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
//     public int solution(int[][] jobs) {
//         N = jobs.length;
//         Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));
        
//         int idx = 0;
//         int now = 0;
//         int finish = 0;
        
//         while (finish < N) {
//             while (idx < N && now <= jobs[idx][0]) {
//                 pq.add(jobs[idx++]);
//             }
            
//             if (pq.isEmpty()) {
//                 now = jobs[idx][0];
//             } else {
//                 int[] process = pq.poll();
//                 answer += process[1] + now - process[0];
//                 now += process[1];
//                 finish += 1;
//             }
//         }
//         return answer / N;
//     }
    
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        int index = 0;
        int count = 0;
        int total = 0;
        int end = 0;
        while(count < jobs.length) {
            
            while(index < jobs.length && jobs[index][0] <= end) {
                pq.add(jobs[index++]);
            }
            
            if(pq.isEmpty()) {
                end = jobs[index][0];
            } else {
                int[] cur = pq.poll();
                total += cur[1] + end - cur[0];
                end += cur[1];
                count++;
            }
        }
        return total / jobs.length;
    }
}