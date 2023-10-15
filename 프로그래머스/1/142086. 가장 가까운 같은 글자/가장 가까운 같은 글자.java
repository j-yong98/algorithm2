import java.util.*;
class Solution {
    int n;
    public int[] solution(String s) {
        n = s.length();
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(i) != s.charAt(j)) continue;
                answer[i] = i - j;
                break;
            }
        }
        return answer;
    }
}