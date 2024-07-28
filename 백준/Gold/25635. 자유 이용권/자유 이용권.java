import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    /**
     * 자유 이용권
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long sum = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            sum += val;
            max = Math.max(max, val);
        }
        long temp = sum - max;
        if (max <= temp) {
            System.out.println(sum);
        } else {
            System.out.println(temp * 2 + 1);
        }
        br.close();
    }

    /**
     * 5 4 4 3
     * 5 4 -> 9
     * 4 3 -> 16
     *
     * 5 4 4 1
     * 5 4 -> 9
     * 3번
     *
     * 5 3 3 1
     * cnt = 6
     * 9 + 3 = 12
     * 0 0 2 1
     */
}