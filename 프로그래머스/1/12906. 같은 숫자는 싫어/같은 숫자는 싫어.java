import java.util.*;
import java.util.stream.IntStream;
public class Solution {
    int N;
    public int[] solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        N = arr.length;
        answer.add(arr[0]);
        for (int i = 1; i < N; i++) {
            if (arr[i] == arr[i - 1]) continue;
            answer.add(arr[i]);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}