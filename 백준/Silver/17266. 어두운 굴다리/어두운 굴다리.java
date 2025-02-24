import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;
    /**
     * 어두운 굴다리
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int l = 0;
        int r = N + 1;
        while (l < r) {
            int mid = (l + r) >> 1;

            boolean res = getHeight(mid);
            if (!res) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        System.out.println(r);
        br.close();
    }

    private static boolean getHeight(int h) {
        int prev = 0;
        for (int i = 0; i < M; i++) {
            if (arr[i] - h > prev) {
                return false;
            } else {
                prev = arr[i] + h;
            }
        }
        return N - prev <= 0;
    }
}