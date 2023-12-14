import java.util.*;
class Solution {
    int N;
    PriorityQueue<Node> minPq = new PriorityQueue<>((a, b) -> a.val == b.val ? Integer.compare(a.idx, b.idx) : Integer.compare(a.val, b.val));
    PriorityQueue<Node> maxPq = new PriorityQueue<>((a, b) -> a.val == b.val ? Integer.compare(a.idx, b.idx) : -Integer.compare(a.val, b.val));
    boolean[] isDelete;
    public int[] solution(String[] operations) {
        N = operations.length;
        isDelete = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(operations[i]);
            String cmd = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            switch (cmd) {
                case "I":
                    Node node = new Node(i, num);
                    minPq.add(node);
                    maxPq.add(node);
                    break;
                case "D":
                    if (num == 1) {
                        delete(maxPq);
                    } else {
                        delete(minPq);
                    }
                    break;
            }
        }
        return getMinMax();
    }
                                                    
    private int[] getMinMax() {
        int[] answer = new int[2];
        
        while (!maxPq.isEmpty() && isDelete[maxPq.peek().idx]) {
            maxPq.poll();
        }
        
        while (!minPq.isEmpty() && isDelete[minPq.peek().idx]) {
            minPq.poll();
        }
        
        if (!maxPq.isEmpty()) {
            answer[0] = maxPq.poll().val;
        }
        if (!minPq.isEmpty()) {
            answer[1] = minPq.poll().val;
        }
        return answer;
    }
                                                    
    private void delete(PriorityQueue<Node> pq) {
        while (!pq.isEmpty() && isDelete[pq.peek().idx])
            pq.poll();
        
        if (pq.isEmpty()) return;
        
        Node node = pq.poll();
        isDelete[node.idx] = true;
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