import java.util.*;
class Solution {
    int N;
    int[] ryan;
    int[] apeach;
    int[] ans;
    int max = 0;
    public int[] solution(int n, int[] info) {
        N = n;
        ryan = new int[11];
        ans = new int[11];
        apeach = info;
        dfs(10, 0);
        if (max == 0)
            return new int[]{-1};
        return ans;
    }
    
    private void dfs(int score, int cnt) {
        if (cnt > N) return;
        if (score == 0 || cnt == N) {
            ryan[10] = N - cnt;
            if (canWin()) {
                for (int i = 0; i < 11; i++)
                    ans[i] = ryan[i];
            }
            ryan[10] = 0;
            return;
        }
        if (N - cnt > apeach[10 - score]) {
            ryan[10 - score] = apeach[10 - score] + 1;
            dfs(score - 1, cnt + ryan[10 - score]);
            ryan[10 - score] = 0;
        }
        dfs(score - 1, cnt);
    }
    
    private boolean canWin() {
        int a = 0;
        int b = 0;
        for (int i = 0; i < 10; i++) {
            if (apeach[i] == 0 && ryan[i] == 0) continue;
            if (apeach[i] >= ryan[i])
                a += 10 - i;
            else
                b += 10 - i;
        }
        int diff = b - a;
        if (b > a && max <= diff) {
            if (max == diff && !isBetter()) return false;
            max = diff;
            return true;
        }
        return false;
    }
    
    private boolean isBetter() {
        for (int i = 10; i >= 0; i--) {
            if (ryan[i] > ans[i]) return true;
            else if (ans[i] > ryan[i]) return false;
        }
        return false;
    }
}