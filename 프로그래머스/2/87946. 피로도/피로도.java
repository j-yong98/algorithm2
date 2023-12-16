class Solution {
    int N;
    int ans = 0;
    public int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        dfs(0, k, 0, dungeons, 0);
        return ans;
    }
    
    private void dfs(int l, int k, int cnt, int[][] dungeons, int visited) {
        if (l == N) {
            ans = Math.max(ans, cnt);
            return;
        }
        for (int i = 0; i < N; i++) {
            if ((visited & (1 << i)) != 0 || k < dungeons[i][0]) continue;
            ans = Math.max(ans, cnt + 1);
            dfs(l + 1, k - dungeons[i][1], cnt + 1, dungeons, visited | (1 << i));
        }
    }
}