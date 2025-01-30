class Solution {
    final int MAX = 100_000;
    int n;
    public int solution(int[] diffs, int[] times, long limit) {
        n = diffs.length;
        int l = 1;
        int r = MAX;
        while (l < r) {
            int mid = (l + r) >> 1;
            
            long taken = calc(mid, diffs, times);
            if (taken > limit) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }
    
    private long calc(int level, int[] diffs, int[] times) {
        long ret = 0;
        int time_cur = 0;
        int time_prev = 0;
        for (int i = 0; i < n; i++) {
            time_cur = times[i];
            if (level >= diffs[i]) {
                ret += time_cur;
            } else {
                ret += wrong(diffs[i] - level, time_cur, time_prev);
            }
            time_prev = times[i];
        }
        return ret;
    }
    
    private int wrong(int repeat, int time_cur, int time_prev) {
        return (time_cur + time_prev) * repeat + time_cur;
    }
}