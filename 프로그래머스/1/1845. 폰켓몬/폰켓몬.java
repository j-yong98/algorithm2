import java.util.*;
class Solution {
    int answer = 0;
    Map<Integer, Integer> map = new HashMap<>();
    public int solution(int[] nums) {
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);
        }
        answer = map.size() > nums.length / 2 ? nums.length / 2 : map.size();
        return answer;
    }
}