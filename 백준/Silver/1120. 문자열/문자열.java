import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /**
     * 문자열
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        br.close();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr[1].length() - arr[0].length() + 1; i++) {
            int cnt = 0;
            for (int j = 0; j < arr[0].length(); j++) {
                if (arr[1].charAt(i + j) != arr[0].charAt(j)) {
                    cnt++;
                }
            }
            ans = Math.min(ans, cnt);
        }
        System.out.println(ans);
    }
}