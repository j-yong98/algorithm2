import java.util.*;
class Solution {
    Map<String, Deque<Integer>> in = new HashMap<>();
    Map<String, Deque<Integer>> out = new HashMap<>();
    Map<String, Integer> ans = new HashMap<>();
    public int[] solution(int[] fees, String[] records) {
        for (int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");
            int time = timeToInt(record[0]);
            String carNumber = record[1];
            String classify = record[2];
            if (classify.equals("IN")) {
                if (!in.containsKey(carNumber)) {
                    in.put(carNumber, new ArrayDeque<>());
                    out.put(carNumber, new ArrayDeque<>());
                }
                in.get(carNumber).addLast(time);
            } else
                out.get(carNumber).addLast(time);
        }
        for (String key : in.keySet()) {
            Deque<Integer> inQ = in.get(key);
            Deque<Integer> outQ = out.get(key);
            int stayTime = 0;
            while (!inQ.isEmpty()) {
                int inTime = inQ.pollFirst();
                int outTime;
                if (outQ.isEmpty())
                    outTime = timeToInt("23:59");
                else
                    outTime = outQ.pollFirst();
                stayTime += outTime - inTime;
            }
            int fee = fees[1];
            if (stayTime > fees[0]) {
                int min = (int) (Math.ceil((double) (stayTime - fees[0]) / fees[2]));
                fee += min * fees[3];
            }
            ans.put(key, fee);
        }
        List<String> res = new ArrayList<>(ans.keySet());
        Collections.sort(res);
        int[] answer = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = ans.get(res.get(i));
        }
        return answer;
    }
    
    private int timeToInt(String time) {
        String[] t = time.split(":");
        return (Integer.parseInt(t[0]) * 60) + Integer.parseInt(t[1]);
    }
}