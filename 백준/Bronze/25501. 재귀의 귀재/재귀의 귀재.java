import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int cnt;

    /**
     * 재귀의 재귀
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            cnt = 0;
            int res = isPalindrome(str);
            sb.append(res).append(" ").append(cnt).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    private static int isPalindrome(String str) {
        return recursion(str, 0, str.length() - 1);
    }

    private static int recursion(String str, int l, int r) {
        cnt++;
        if (l >= r) {
            return 1;
        } else if (str.charAt(l) != str.charAt(r)) {
            return 0;
        }
        return recursion(str, l + 1, r - 1);
    }
}