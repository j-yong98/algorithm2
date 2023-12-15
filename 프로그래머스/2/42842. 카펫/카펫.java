class Solution {
    public int[] solution(int brown, int yellow) {
        int area = brown + yellow;
        
        for (int i = 3; i < area; i++) {
            int j = area / i;
            if (area % i == 0 && j >= 3) {
                int w = Math.max(i, j);
                int h = Math.min(i, j);
                int c = (w - 2) * (h - 2);
                if (c == yellow) {
                    return new int[]{w, h};
                }
            }
        }
        
        return new int[2];
    }
}