import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[] str;
    static boolean isFinish = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        str = br.readLine().toCharArray();
        f(0, 0, 0, 0);
    }

    private static void f(int idx, int cnt, int left, int right) {
        if (isFinish) {
            return;
        }
        if (idx == str.length) {
            if (left == right) {
                String s = new String(str);
                System.out.println(s);
                isFinish = true;
            }
            return;
        }

        if (str[idx] == 'G') {
            str[idx] = '(';
            f(idx, cnt, left, right);
            if (cnt > 0) {
                str[idx] = ')';
                f(idx, cnt, left, right);
            }
            return;
        }

        if (str[idx] == '(') {
            f(idx + 1, cnt + 1, left + 1, right);
        } else {
            f(idx + 1, cnt - 1, left, right + 1);
        }
    }

}