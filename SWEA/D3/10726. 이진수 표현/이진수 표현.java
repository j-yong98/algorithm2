import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    /**
     * 이진수 표현
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            boolean flag = true;
            int x = (1 << n) - 1;
            flag = (m & x) == x;
            sb.append("#").append(t).append(" ").append(flag ? "ON\n" : "OFF\n");
        }
        System.out.println(sb);
        br.close();
    }
}