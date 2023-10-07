import java.util.*;
class Solution {
    int N;
    int[][] tired = {
        {1, 1, 1},
        {5, 1, 1},
        {25, 5, 1}
    };
    int[] arr;
    Map<String, Integer> mineralNum = new HashMap<>();
    
    public Solution() {
        mineralNum.put("diamond", 0);
        mineralNum.put("iron", 1);
        mineralNum.put("stone", 2);
    }
    
    public int solution(int[] picks, String[] minerals) {
        int total = Arrays.stream(picks).sum();
        N = minerals.length;
        List<int[]> group = new ArrayList<>();
        for (int i = 0; i < N; i += 5) {
            if (total == 0) break;
            int dia = 0;
            int iron = 0;
            int stone = 0;
            
            for (int j = i; j < i + 5; j++) {
                if (j == N) break;
                int idx = mineralNum.get(minerals[j]);
                
                dia += tired[0][idx];
                iron += tired[1][idx];
                stone += tired[2][idx];
            }
            
            group.add(new int[]{dia, iron, stone});
            total--;
        }
        
        Collections.sort(group, (a, b) -> Integer.compare(b[2], a[2]));
        
        int ans = 0;
        for (int[] mineral : group) {
            if (picks[0] > 0) {
                ans += mineral[0];
                picks[0]--;
                continue;
            }
            if (picks[1] > 0) {
                ans += mineral[1];
                picks[1]--;
                continue;
            }
            if (picks[2] > 0) {
                ans += mineral[2];
                picks[2]--;
                continue;
            }            
        }
        return ans;
    }
}