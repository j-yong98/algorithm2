class Solution {
    public int[] solution(String[] wallpaper) {
        int y1 = 100, x1 = 100, y2 = -1, x2 = -1;
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    y1 = Math.min(y1, i);
                    x1 = Math.min(x1, j);
                    y2 = Math.max(y2, i);
                    x2 = Math.max(x2, j);
                }
            }
        }
        return new int[]{y1, x1, y2 + 1, x2 + 1};
    }
}