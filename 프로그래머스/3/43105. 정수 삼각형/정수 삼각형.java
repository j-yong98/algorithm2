import java.util.*;
class Solution {
    int[][] dp;
    public int solution(int[][] triangle) {
        int N = triangle.length;
        dp = new int[N][N];
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < N; i++) {
            int len = triangle[i].length;
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            dp[i][len - 1] = dp[i - 1][len - 2] + triangle[i][len - 1];
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
            }
        }
        return Arrays.stream(dp[N - 1]).max().getAsInt();
    }
}