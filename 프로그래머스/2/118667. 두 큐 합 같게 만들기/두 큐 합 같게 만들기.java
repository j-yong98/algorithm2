import java.util.*;
class Solution {
    Deque<Integer> q1 = new ArrayDeque<>();
    Deque<Integer> q2 = new ArrayDeque<>();
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0;
        long sum2 = 0;
        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            q1.add(queue1[i]);
        }
        for (int i = 0; i < queue2.length; i++) {
            sum2 += queue2[i];
            q2.add(queue2[i]);
        }
        int cnt = 0;
        int len = q1.size() + q2.size();
        while (cnt <= len * 4 && sum1 != sum2) {
            cnt++;
            if (sum1 < sum2) {
                int tmp = q2.pollFirst();
                sum1 += tmp;
                sum2 -= tmp;
                q1.add(tmp);
            } else {
                int tmp = q1.pollFirst();
                sum1 -= tmp;
                sum2 += tmp;
                q2.add(tmp);
            }
        }
        return sum1 == sum2 ? cnt : -1;
    }
}