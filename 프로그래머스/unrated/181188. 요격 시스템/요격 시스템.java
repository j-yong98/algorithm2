import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int ans = 1;
        Arrays.sort(targets, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        int end = targets[0][1];
        for (int i = 1; i < targets.length; i++) {
            if (end > targets[i][0])
                end = Math.min(end, targets[i][1]);
            else {
                ans++;
                end = targets[i][1];
            }
        }
        return ans;
    }
}