import java.util.*;
class Solution {
    int N, M;
        Map<String, Integer> index = new HashMap<>();
        int[][] sendReceive;
        int[][] score;
        int[] result;
        public int solution(String[] friends, String[] gifts) {
            N = friends.length;
            M = gifts.length;
            sendReceive = new int[N][N];
            score = new int[N][3];
            result = new int[N];
            for (int i = 0; i < N; i++) {
                index.put(friends[i], i);
            }
            for (int i = 0; i < M; i++) {
                String[] split = gifts[i].split(" ");
                int send = index.get(split[0]);
                int receive = index.get(split[1]);
                sendReceive[send][receive] += 1;
                score[send][0] += 1;
                score[receive][1] += 1;
            }
            for (int i = 0; i < N; i++) {
                score[i][2] = score[i][0] - score[i][1];
            }

            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (isDiff(i, j)) { //둘이 선물 주고 받은 기록이 있다면 더 많이 준 사람에게 + 1
                        if (sendReceive[i][j] > sendReceive[j][i]) {
                            result[i]++;
                        } else {
                            result[j]++;
                        }
                    } else {//주고 받은 선물 기록이 없거나 같다면 선물 지수가 더 큰 사람에게 + 1
                        if (score[i][2] > score[j][2]) {
                            result[i]++;
                        } else if (score[i][2] < score[j][2]) {
                            result[j]++;
                        }
                    }
                }
            }
            return Arrays.stream(result).max().getAsInt();
        }
        private boolean isDiff(int send, int receive) {
            return sendReceive[send][receive] != sendReceive[receive][send];
        }
}