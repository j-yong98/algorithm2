import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static Set<String> set = new HashSet<>();
    static String S, T;
    static boolean flag = false;
    /**
     * A와 B 2
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();
        dfs(new StringBuilder(T));
        System.out.println(flag ? 1 : 0);
        br.close();
    }

    private static void dfs(StringBuilder sb) {
        if (sb.toString().equals(S)) {
            flag = true;
            return;
        }
        int len = sb.length();
        if (len < S.length()) {
            return;
        }
        if (sb.charAt(len - 1) == 'A') {
            char c = sb.charAt(len - 1);
            sb.deleteCharAt(len - 1);
            dfs(new StringBuilder(sb));
            sb.append(c);
        }
        if (sb.charAt(0) == 'B') {
            sb.deleteCharAt(0);
            sb.reverse();
            dfs(new StringBuilder(sb));
        }
    }
}