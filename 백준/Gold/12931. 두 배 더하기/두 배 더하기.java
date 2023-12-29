import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    /**
     * 두 배 더하기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int oddCnt = 0;
        int evenCnt = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] >= 1) {
                int[] tmp = getCnt(i);
                evenCnt = Math.max(evenCnt, tmp[1]);
                oddCnt += tmp[0];
            }
        }
        System.out.println(evenCnt + oddCnt);
        br.close();
    }

    private static int[] getCnt(int idx) {
        int odd = 0;
        int even = 0;
        while (arr[idx] > 0) {
            if (arr[idx] % 2 == 1) {
                arr[idx] -= 1;
                odd += 1;
            } else {
                arr[idx] /= 2;
                even += 1;
            }
        }
        return new int[]{odd, even};
    }
    /**
     * 0 0
     *
     * 1 0
     * 2 0
     * 2 1
     */
}