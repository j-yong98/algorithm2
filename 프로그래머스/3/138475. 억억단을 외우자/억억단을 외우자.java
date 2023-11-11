import java.util.*;
class Solution {
    public int[] solution(int e, int[] starts) {
        int[] dp = new int[e + 1];
        Arrays.fill(dp, 1);
        for (int i = 2; i <= e; i++) {
            for (int j = i; j <= e; j += i) {
                dp[j] += 1;
            }
        }
        int N = starts.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(starts[i], i);
        }
        
        int[] ans = new int[N];
        Arrays.sort(starts);
        int max = 0;
        int idx = 0;
        for (int i = 0; i < N; i++) {
            int s = starts[i];
            
            if (idx >= s) {
                ans[map.get(s)] = idx;
                continue;
            }
            
            idx = 0;
            max = 0;
            for (int j = s; j <= e; j++) {
                if (dp[j] > max) {
                    max = dp[j];
                    idx = j;
                }
            }
            ans[map.get(s)] = idx;
        }
        return ans;  
    }
}