import java.util.*;
class Solution {
    final int MAX = 240;
    int[] arr = new int[MAX + 1];
    public int solution(int[] people, int limit) {
        int N = people.length;
        for (int i = 0; i < N; i++) {
            arr[people[i]]++;
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int x = people[i];
            if (arr[x] == 0) {
                continue;
            }
            int y = limit - x;
            boolean flag = false;
            for (int j = y; j >= 1; j--) {
                if (arr[j] == 0 || (x == j && arr[x] <= 1)) {
                    continue;
                }
                flag = true;
                arr[x]--;
                arr[j]--;
                break;
            }
            if (!flag) {
                arr[x]--;
            }
            ans++;
        }
        return ans;
    }
}