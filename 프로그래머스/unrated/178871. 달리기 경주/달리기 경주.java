import java.util.*;
class Solution {
    int N;
    Map<String, Integer> p = new HashMap<>();
    public String[] solution(String[] players, String[] callings) {
        N = players.length;
        for (int i = 0; i < N; i++)
            p.put(players[i], i);
        for (int i = 0; i < callings.length; i++) {
            int idx = p.get(callings[i]);
            p.put(callings[i], idx - 1);
            String tmp = players[idx];
            players[idx] = players[idx - 1];
            players[idx - 1] = tmp;
            p.put(players[idx], idx);
        }
        return players;
    }
}