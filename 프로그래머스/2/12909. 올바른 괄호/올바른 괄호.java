import java.util.*;
class Solution {
    int N;
    Stack<Character> stack = new Stack<>();
    boolean solution(String s) {
        N = s.length();
        char[] chs = s.toCharArray();
        for (int i = 0; i < N; i++) {
            if (chs[i] == '(') {
                stack.add(chs[i]);
            } else {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}