import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static int N;
    static int[] dp;

    /**
     * 부분 문자열 뽑기 게임
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        Arrays.fill(dp, -1);
        if (N < 10) {
            System.out.println(-1);
        } else {
            int res = f(N);
            System.out.println(res == Integer.MAX_VALUE ? -1 : res);
        }
        br.close();
    }

    private static int f(int n) {
        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = Integer.MAX_VALUE;
        Set<Integer> sub = getSub(n);
        for (Integer s : sub) {
            int res = f(n - s);
            if (res == Integer.MAX_VALUE) {
                dp[n] = Math.min(dp[n], s);
            }
        }
        return dp[n];
    }

    private static Set<Integer> getSub(int n) {
        Set<Integer> set = new HashSet<>();
        String str = String.valueOf(n);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                continue;
            }
            String temp = "";
            for (int j = i; j < str.length(); j++) {
                temp += str.charAt(j);
                if (!str.equals(temp)) {
                    set.add(Integer.parseInt(temp));
                }
            }
        }
        return set;
    }
}