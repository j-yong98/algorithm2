import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] count = new int[32];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            for (int j = 0; j < 32; j++)
                count[j] += (num >> j) & 1;
        }
        long ans = 0;
        for (int i = 0; i < 32; i++) {
            long one = count[i];
            long zero = N - one;

            ans += ((one * zero) * (1 << i));
        }
        System.out.println(ans);
    }
}