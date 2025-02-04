import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    /**
     * 방 번호
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if (N == 0) {
            System.out.println(1);
            return;
        }
        int[] cnt = new int[10];
        while (N > 0) {
            int r = N % 10;
            N /= 10;
            cnt[r]++;
        }
        cnt[6] = (cnt[6] + cnt[9]) / 2 + (cnt[6] + cnt[9]) % 2;
        System.out.println(Arrays.stream(cnt, 0, 9).max().getAsInt());
        br.close();
    }
}