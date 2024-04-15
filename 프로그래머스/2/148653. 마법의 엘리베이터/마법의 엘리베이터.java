class Solution {
    public int solution(int storey) {
        int ans = 0;
        while (storey > 0) {
            int r = storey % 10;
            storey /= 10;
            
            if (r > 5) {
                ans += 10 - r;
                storey++;
            } else if (r < 5) {
                ans += r;
            } else if (storey % 10 >= 5) {
                ans += r;
                storey++;
            } else {
                ans += r;
            }
        }
        return ans;
    }
}