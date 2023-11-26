import java.util.*;
class Solution {
    final int MAX = 1_000_000;
    int[] dp = new int[MAX + 1];
    public int solution(int x, int y, int n) {
        int answer = 0;
        Arrays.fill(dp, MAX + 10);
        dp[x] = 0;
        for (int i = x; i <= y; i++) {
            if (dp[i] == MAX + 10) continue;
            if (i + n <= MAX) {
                dp[i + n] = Math.min(dp[i] + 1, dp[i + n]);
            } 
            if (i * 2 <= MAX) {
                dp[i * 2] = Math.min(dp[i] + 1, dp[i * 2]);
            }
            if (i * 3 <= MAX) {
                dp[i * 3] = Math.min(dp[i] + 1, dp[i * 3]);
            }
        }
        return dp[y] == MAX + 10 ? -1 : dp[y];
    }
}