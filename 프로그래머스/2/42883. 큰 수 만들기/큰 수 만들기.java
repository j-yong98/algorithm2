import java.util.*;
class Solution {
    public String solution(String number, int k) {
        char[] ch = number.toCharArray();
        StringBuilder sb = new StringBuilder();
        int target = number.length() - k;
        for (int i = 0; i < ch.length; i++) {
            char a = ch[i];
            while (!canRemove(i, ch.length, sb.length(), target) && sb.length() != 0) {
                char b = sb.charAt(sb.length() - 1);
                if (compare(a, b) > 0) sb.deleteCharAt(sb.length() - 1);
                else
                    break;
            }
            if (sb.length() < target)
                sb.append(a);
        }
        return sb.toString();
    }

    private int compare(char a, char b) {
        return a - b;
    }
    
    private boolean canRemove(int index, int len, int now, int target) {
        if ((len - index) + now <= target) return true;
        return false;
    }
}