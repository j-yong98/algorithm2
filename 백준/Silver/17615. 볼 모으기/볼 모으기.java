import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    static int N;
    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = br.readLine().toCharArray();
        boolean flag = false;
        int ans = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == 'R') flag = true;
            else if (flag) cnt++;
        }
        ans = Math.min(ans, cnt);
        cnt = 0;
        flag = false;
        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] == 'R') flag = true;
            else if (flag) cnt++;
        }
        ans = Math.min(ans, cnt);
        cnt = 0;
        flag = false;
        for (int i = 0; i < N; i++) {
            if (arr[i] == 'B') flag = true;
            else if (flag) cnt++;
        }
        ans = Math.min(ans, cnt);
        cnt = 0;
        flag = false;
        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] == 'B') flag = true;
            else if (flag) cnt++;
        }
        ans = Math.min(ans, cnt);
        System.out.println(ans);
        br.close();
    }
}