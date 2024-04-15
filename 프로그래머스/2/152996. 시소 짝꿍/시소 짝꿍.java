import java.util.*;
class Solution {
    int[][] arr = {{1, 1}, {1, 2}, {2, 3}, {3, 4}};
    Map<Double, Long> map = new HashMap<>();
    public long solution(int[] weights) {
        Arrays.sort(weights);
        long ans = 0;
        for (int i = 0; i < weights.length; i++) {
            int w = weights[i];
            for (int j = 0; j < arr.length; j++) {
                Double key = (double) w * arr[j][0] / arr[j][1];
                if (map.containsKey(key)) {
                    ans += map.get(key);
                }
            }
            map.put(w * 1.0, map.getOrDefault(w * 1.0, 0L) + 1);
        }
        return ans;
    }
}