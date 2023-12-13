import java.util.*;
class Solution {
    Deque<Integer> wating = new ArrayDeque<>();
    Deque<int[]> passing = new ArrayDeque<>();
    int time;
    int N;
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        N = truck_weights.length;
        for(int truck : truck_weights) {
            wating.offerLast(truck);
        }
        int passingWeights = 0;
        int passedCount = 0;
        while (passedCount < N) {
            time++;
            if (!wating.isEmpty() && passingWeights + wating.peek() <= weight) {
                int truck = wating.pollFirst();
                passingWeights += truck;
                passing.offerLast(new int[]{truck, 0});
            }
            int size = passing.size();
            for (int i = 0; i < size; i++) {
                int[] p = passing.pollFirst();
                p[1]++;
                if (p[1] == bridge_length) {
                    passingWeights -= p[0];
                    passedCount += 1;
                    continue;
                }
                passing.offerLast(p);
            }
        }
        return time + 1;
    }
}