import java.util.*;
class Solution {
    int N;
    int idx = 0;
    List<Integer> answer = new ArrayList<>();
    public int[] solution(int[] progresses, int[] speeds) {
        N = progresses.length;
        for (int day = 0; idx < N; day++) {
            int cnt = 0;
            while (idx < N && progresses[idx] + day * speeds[idx] >= 100) {
                idx++;
                cnt++;
            }
            if (cnt != 0) {
                answer.add(cnt);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}