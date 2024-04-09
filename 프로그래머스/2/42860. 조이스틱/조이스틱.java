import java.util.*;
class Solution {
    public int solution(String name) {
        int answer = 0;
        char[] arr = name.toCharArray();
        int ans = arr.length - 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 'A') {
                int left = i - 1;
                while (i < arr.length && arr[i] == 'A') {
                    i++;
                }
                int right = arr.length - i;
                ans = Math.min(ans, 2 * left + right);
                ans = Math.min(ans, 2 * right + left);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            ans += minAlpha(arr[i]);
        }
        return ans;
    }
    
    private int minAlpha(char c) {
        return Math.min(c - 'A', 'Z' - c + 1);
    }
}