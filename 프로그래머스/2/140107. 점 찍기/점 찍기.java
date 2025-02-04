class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for (int x = 0; x <= d; x+=k) {
            long xx = (long) x * x;
            long dd = (long) d * d;
            
            int y = (int) Math.sqrt(dd - xx);
            int v = (y / k);
            
            answer += v + 1;
        }
        return answer;
    }
}