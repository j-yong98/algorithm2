import java.util.*;
class Solution {
    int N;
    Stack<Node> s = new Stack<>();
    int[] answer;
    public int[] solution(int[] prices) {
        N = prices.length;
        answer = new int[N];
        for (int i = 0; i < N; i++) {
            int price = prices[i];
            while (!s.isEmpty()) {
                Node top = s.peek();
                if (top.val <= price) {
                    break;
                } else {
                    s.pop();
                    answer[top.idx] = i - top.idx;
                }
            }
            s.add(new Node(i, price));
        }
        while (!s.isEmpty()) {
            Node top = s.pop();
            answer[top.idx] = N - top.idx - 1;
        }
        return answer;
    }
    
    static class Node {
        int idx;
        int val;
        
        public Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
}