import java.util.*;
import java.util.stream.IntStream;
public class Solution {
    int N;
    Stack<Integer> s = new Stack<>();
    public int[] solution(int[] arr) {
        N = arr.length;
        for (int i = 0; i < N; i++) {
            if (s.isEmpty()) {
                s.add(arr[i]);
            } else {
                if (s.peek() == arr[i]) continue;
                s.add(arr[i]);
            }
        }
        int[] answer = new int[s.size()];
        int idx = s.size() - 1;
        while (!s.isEmpty()) {
            answer[idx--] = s.pop();
        }
        return answer;
    }
}