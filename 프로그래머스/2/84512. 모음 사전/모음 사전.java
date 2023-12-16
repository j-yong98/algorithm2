import java.util.*;
class Solution {
    final char[] chars = {'A', 'E', 'I', 'O', 'U'};
    int ans = 0;
    int order = 0;
    public int solution(String word) {
        dfs(0, new StringBuilder(), word);
        return ans;
    }
    
    private void dfs(int l, StringBuilder sb, String word) {
        if (sb.toString().equals(word)) {
            ans = order;
            return;
        }
        if (l == 5) {
            return;
        }
        for (char c : chars) {
            order++;
            sb.append(c);
            dfs(l + 1, sb, word);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}