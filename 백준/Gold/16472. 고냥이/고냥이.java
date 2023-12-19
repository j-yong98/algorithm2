import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] alpha = new int[26];
    static int cnt = 0;
    static int N;
    static String str;
    static int ans = 0;
    /**
     * 고냥이
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        str = br.readLine();
        int len = str.length();
        int l = 0, r = 0;
        alpha[str.charAt(l) - 'a'] += 1;
        cnt = 1;
        while (r < len - 1) {
            char c = str.charAt(r + 1);
            if (alpha[c - 'a'] > 0) {
                alpha[c - 'a']++;
                r++;
            } else if (alpha[c - 'a'] == 0 && cnt + 1 <= N) {
                alpha[c - 'a']++;
                cnt += 1;
                r++;
            } else {
                char ch = str.charAt(l);
                alpha[ch - 'a']--;
                if (alpha[ch - 'a'] == 0) {
                    cnt -= 1;
                }
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        System.out.println(ans);
        br.close();
    }
}