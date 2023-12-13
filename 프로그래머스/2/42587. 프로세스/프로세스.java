import java.util.*;
class Solution {
    final int SIZE = 10;
    Deque<Node> q;
    int N;
    int[] cnt = new int[SIZE];
    int[] rank;
    int r = 1;
    public int solution(int[] priorities, int location) {
        N = priorities.length;
        rank = new int[N];
        q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            cnt[priorities[i]]++;
            q.offerLast(new Node(i, priorities[i]));
        }
        while (!q.isEmpty() && rank[location] == 0) {
            Node now = q.peekFirst();
            boolean flag = false;
            for (int i = now.priority + 1; i < 10; i++) {
                if (cnt[i] > 0) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                q.offerLast(q.pollFirst());
            } else {
                q.pollFirst();
                rank[now.idx] = r++;
                cnt[now.priority]--;
            }
        }
        System.out.println(Arrays.toString(rank));
        return rank[location];
    }
    
    static class Node {
        int idx;
        int priority;
        
        public Node(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }
}