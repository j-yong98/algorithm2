import java.util.*;
class Solution {
    int N;
    PriorityQueue<Homework> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.startTime, b.startTime));
    Deque<Homework> q = new ArrayDeque<>();
    int idx = 0;
    String[] ans;
    public String[] solution(String[][] plans) {
        N = plans.length;
        ans = new String[N];
        for (int i = 0; i < N; i++) {
            Homework h = new Homework();
            h.name = plans[i][0];
            h.startTime = stringToInt(plans[i][1]);
            h.playTime = Integer.parseInt(plans[i][2]);
            pq.add(h);
        }
        Homework doing = null;
        int time = 0;
        while (!pq.isEmpty()) {
            if (doing == null) {
                doing = pq.poll();
                time = doing.startTime;
            }
            else {
                if (doing.playTime == 0) {
                    ans[idx++] = doing.name;
                    if (!q.isEmpty())
                        doing = q.pollFirst();
                    else
                        doing = null;
                }
                if (time > pq.peek().startTime) {
                    q.offerFirst(doing);
                    doing = pq.poll();
                }
            }
            if (doing != null)
                doing.playTime--;
            time++;
        }
        if (doing != null)
            ans[idx++] = doing.name;
        while (!q.isEmpty())
            ans[idx++] = q.pollFirst().name;
        return ans;
    }
    
    private int stringToInt(String time) {
        String[] t = time.split(":");
        int ret = 0;
        ret = Integer.parseInt(t[0]) * 60;
        ret += Integer.parseInt(t[1]);
        return ret;
    }
    
    static class Homework {
        String name;
        int startTime;
        int playTime;
    }
}