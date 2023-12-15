
class Solution {
    public int solution(int[][] sizes) {
        sort(sizes);
        int max = 0;
        int min = 0;
        for (int i = 0; i < sizes.length; i++) {
            max = Math.max(max, sizes[i][0]);
            min = Math.max(min, sizes[i][1]);
        }
        System.out.println(max + " " + min);
        return max * min;
    }
    
    private void sort(int[][] sizes) {
        for (int[] size : sizes) {
            int a = size[0];
            int b = size[1];
            size[0] = Math.max(a, b);
            size[1] = Math.min(a, b);
        }
    }
}