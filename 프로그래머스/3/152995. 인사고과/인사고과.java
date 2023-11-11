import java.util.*;
class Solution {
    int N;
    public int solution(int[][] scores) {
        int[] wanho = scores[0];
        N = scores.length;
        Arrays.sort(scores, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0])
                    return Integer.compare(a[1], b[1]);
                return Integer.compare(b[0], a[0]);
            }
        });
        int tmp = 0;
        int rank = 0;
        for (int i = 0; i < N; i++) {
            if (wanho[0] < scores[i][0] && wanho[1] < scores[i][1])
                return -1;
            if (tmp <= scores[i][1]) {
                if (wanho[0] + wanho[1] < scores[i][0] + scores[i][1])
                    rank++;
                tmp = scores[i][1];
            }
        }
        return rank + 1;
    }
}