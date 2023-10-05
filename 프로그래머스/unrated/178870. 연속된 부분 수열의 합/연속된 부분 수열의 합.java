class Solution {
    int N;
    int[] pos;
    public int[] solution(int[] sequence, int k) {
        N = sequence.length;
        int sum = 0;
        int l = 0;
        int r = 0;
        for (int i = l; i <= r; i++)
            sum += sequence[i];
        while (l <= r) {
            if (sum == k) {
                if (pos == null)
                    pos = new int[]{l, r};
                else {
                    if ((pos[1] - pos[0] + 1) > (r - l + 1)) {
                        pos[0] = l;
                        pos[1] = r;
                    }
                }
                sum -= sequence[l++];
            } else if (r < N - 1 && sum < k)
                sum += sequence[++r];
            else
                sum -= sequence[l++];
        }
        return pos;
    }
}