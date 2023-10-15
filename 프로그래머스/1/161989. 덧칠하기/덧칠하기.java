class Solution {
    public int solution(int n, int m, int[] section) {
        boolean[] arr = new boolean[n + 1];
        for (int s : section) {
            arr[s] = true;
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (!arr[i]) continue;
            ans += 1;
            for (int j = 0; j < m; j++) {
                if (i + j > n) break;
                arr[i + j] = false;
            }
        }
        return ans;
    }
}