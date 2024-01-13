import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final char[] arr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    /**
     * 16진수
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        int ans = 0;
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == str[i]) {
                    ans *= 16;
                    ans += j;
                    break;
                }
            }
        }
        System.out.println(ans);
        br.close();
    }
}