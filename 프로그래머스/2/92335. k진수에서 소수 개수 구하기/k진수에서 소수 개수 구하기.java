import java.util.*;
class Solution {
    public int solution(int n, int k) {
        String num = convert(n, k);
        int cnt = 0;
        String[] split = num.split("0");
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("")) continue;
            long tmp = Long.parseLong(split[i]);
            if (isPrime(tmp)) cnt++;
        }
        return cnt;
    }
    
    private boolean isPrime(long num) {
        if (num == 0 || num == 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    
    private String convert(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        return sb.reverse().toString();
    }
}