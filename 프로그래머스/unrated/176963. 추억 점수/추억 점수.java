import java.util.*;
class Solution {
    Map<String, Integer> map = new HashMap<>();
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        int aIdx = 0;
        for (int i = 0; i < name.length; i++)
            map.put(name[i], i);
        for (int i = 0; i < photo.length; i++) {
            int sum = 0;
            for (int j = 0; j < photo[i].length; j++) {
                if (!map.containsKey(photo[i][j])) continue;
                int idx = map.get(photo[i][j]);
                sum += yearning[idx];
            }
            answer[aIdx++] = sum;
        }
        return answer;
    }
}