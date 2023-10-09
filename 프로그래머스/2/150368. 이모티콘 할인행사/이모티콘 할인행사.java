
class Solution {
    final int[] sales = {10, 20, 30, 40};
    int[] fees;

    /**
     * 이모티콘 할인 행사
     */
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        fees = new int[users.length];
        comb(0, emoticons, users, answer);
        System.out.println(answer[0] + " " + answer[1]);
        return answer;
    }

    private void comb(int idx, int[] emoticons, int[][] users, int[] answer) {
        if (idx == emoticons.length) {
            int cnt = 0;
            int total = 0;
            for (int i = 0; i < users.length; i++) {
                if (users[i][1] <= fees[i]) cnt++;
                else total += fees[i];
            }
            if (answer[0] < cnt) {
                answer[0] = cnt;
                answer[1] = total;
            } else if (answer[0] == cnt)
                answer[1] = Math.max(answer[1], total);
            return;
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < users.length; j++) {
                if (sales[i] < users[j][0]) continue;
                int res = (100 - sales[i]) * emoticons[idx] / 100;
                fees[j] += res;
            }
            comb(idx + 1, emoticons, users, answer);
            for (int j = 0; j < users.length; j++) {
                if (sales[i] < users[j][0]) continue;
                int res = (100 - sales[i]) * emoticons[idx] / 100;
                fees[j] -= res;
            }
        }
    }
}
