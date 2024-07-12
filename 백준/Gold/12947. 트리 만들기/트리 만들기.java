import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] cnt;
    /**
     * 트리 만들기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cnt = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cnt[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        int temp = 0;
        for (int i = 1; i <= N; i++) {
            max++;
            if (cnt[i] == 1) {
                max = Math.max(max, temp + 1);
                temp = 0;
            } else {
                temp += 2;
            }
        }
        System.out.println(Math.max(max, temp));
        br.close();
    }
}