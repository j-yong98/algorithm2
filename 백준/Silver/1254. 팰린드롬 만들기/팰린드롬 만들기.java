import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String str;

    /**
     * 팰린드롬 만들기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        int len = str.length();
        for (int i = 0; i < str.length(); i++) {
            String temp = str.substring(i);
            if (isPal(temp)) {
                System.out.println(len);
                return;
            }
            len++;
        }
        br.close();
    }

    private static boolean isPal(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}