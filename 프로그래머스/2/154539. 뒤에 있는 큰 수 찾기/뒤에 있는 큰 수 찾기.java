import java.util.*;
class Solution {
    int N;
    int[] ans;
    public int[] solution(int[] numbers) {
        Stack<int[]> s = new Stack<>();
        N = numbers.length;
        ans = new int[N];
        Arrays.fill(ans, -1);
        for (int i = 0; i < N; i++) {
            int num = numbers[i];
            while (!s.isEmpty()) {
                int[] top = s.peek();
                if (top[0] < num) {
                    ans[top[1]] = num;
                    s.pop();
                } else {
                    break;
                }
            }
            s.push(new int[]{numbers[i], i});
        }
        return ans;
    }
}