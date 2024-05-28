import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int MOD = 1_000_000_007;
    static int N;
    static char[] arr;
    static int[] sum = new int[4];
    /**
     * 나는 정말 휘파람을 못불어
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = br.readLine().toCharArray();
        for (int i = 0; i < N; i++) {
            if (arr[i] == 'W') {
                sum[0] = (sum[0] + 1) % MOD;
            } else if (arr[i] == 'H') {
                sum[1] = (sum[1] + sum[0]) % MOD;
            } else if (arr[i] == 'E') {
                sum[3] = (((sum[3] + sum[3]) % MOD) + sum[2]) % MOD;
                sum[2] = (sum[2] + sum[1]) % MOD;
            }
        }
        System.out.println(sum[3]);
        br.close();
    }

}