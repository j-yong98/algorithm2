import java.util.Arrays;

class Solution {
    long[][] ans;

    /**
     * 연속 펄스 부분 수열의 합
     */
    public long solution(int[] sequence) {
        int len = sequence.length;
        ans = new long[2][len];
        /**
         * 0 - 1 -1 1 -1 1 -1 ...
         * 1 - -1 1 -1 1 -1 1 ...
         */
        ans[0][0] = sequence[0];
        ans[1][0] = -sequence[0];
        for (int i = 1; i < len; i++) {
            for (int k = 0; k < 2; k++) {
                long tmp = getNum(i, k, sequence);
                ans[k][i] = Math.max(tmp, ans[k][i - 1] + tmp);
            }
        }
        return Arrays.stream(ans).flatMapToLong(Arrays::stream).max().getAsLong();
    }

    private long getNum(int i, int k, int[] sequence) {
        if (i % 2 == 0)
            return k == 0 ? sequence[i] : -sequence[i];
        return k == 0 ? -sequence[i] : sequence[i];
    }
}