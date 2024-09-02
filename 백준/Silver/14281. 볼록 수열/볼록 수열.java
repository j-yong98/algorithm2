import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static long cnt = 0;
    /**
     * 블록 수열
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        while (f());
        System.out.println(cnt);
        br.close();
    }

    private static boolean f() {
        boolean flag = false;
        for (int i = 1; i < N - 1; i++) {
            if (!isTrue(i)) {
                int diff = arr[i] - (arr[i - 1] + arr[i + 1]) / 2;
                cnt += diff;
                arr[i] -= diff;
                flag = true;
            }
        }
        return flag;
    }

    private static boolean isTrue(int idx) {
        return 2 * arr[idx] <= arr[idx - 1] + arr[idx + 1];
    }
}