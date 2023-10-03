import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static int N;
    static String str;
    static Stack<Integer> s = new Stack<>();
    static boolean[] arr;
    static int ans = 0;
    /**
     * 현욱이는 괄호왕이야!!
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        str = br.readLine();
        arr = new boolean[N];
        for (int i = 0; i < N; i++) {
            char c = str.charAt(i);
            if (c == '(')
                s.push(i);
            else {
                if (!s.isEmpty()) {
                    int idx = s.pop();
                    arr[idx] = arr[i] = true;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (!arr[i]) {
                ans = Math.max(ans, cnt);
                cnt = 0;
            } else
                cnt++;
        }
        ans = Math.max(ans, cnt);
        System.out.println(ans);
        br.close();
    }
}