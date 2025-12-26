import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '*') {
                continue;
            }
            if (i % 2 == 0) {
                sum += ch - '0';
            } else {
                sum += (ch - '0') * 3;
            }
        }
        boolean isEven = str.indexOf('*') % 2 == 0;
        for (int i = 0; i < 10; i++) {
            int temp = sum;
            if (isEven) {
                temp += i;
            } else {
                temp += i * 3;
            }
            if (temp % 10 == 0) {
                int ans = temp == 10 ? 0 : i;
                System.out.println(ans);
                break;
            }
        }
    }

}