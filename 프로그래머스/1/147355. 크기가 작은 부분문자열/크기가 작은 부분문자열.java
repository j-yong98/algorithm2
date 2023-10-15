class Solution {
    int m;
    public int solution(String t, String p) {
        int answer = 0;
        m = p.length();
        long b = Long.parseLong(p);
        for (int i = 0; i < t.length(); i++) {
            if (i + m > t.length()) break;
            String sub = t.substring(i, i + m);
            long a = Long.parseLong(sub);
            if (a <= b) answer += 1;
        }
        return answer;
    }
}