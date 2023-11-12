import java.util.*;
class Solution {
    final int CLEAN_TIME = 10;
    int N;
    int[][] bookTime;
    public int solution(String[][] book_time) {
        N = book_time.length;
        bookTime = new int[N][2];
        for (int i = 0; i < N; i++) {
            int start = convertTime(book_time[i][0]);
            int end = convertTime(book_time[i][1]);
            bookTime[i] = new int[]{start, end + CLEAN_TIME};
        }
        Arrays.sort(bookTime, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            if (pq.isEmpty())
                pq.add(bookTime[i][1]);
            else {
                if (pq.peek() > bookTime[i][0]) {
                    pq.add(bookTime[i][1]);
                } else {
                    pq.poll();
                    pq.add(bookTime[i][1]);
                }
            }
        }
        return pq.size();
    }
    
    private int convertTime(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60  
            + Integer.parseInt(split[1]);
    }
}