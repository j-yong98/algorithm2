import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] arr;

    /**
     * 공유기 설치
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int l = 0;
        int r = Integer.MAX_VALUE;
        while (l < r) {
            int m = (l + r) >> 1;

            int cnt = getCnt(m);
            if (cnt >= K) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        System.out.println(l - 1);
        br.close();
    }

    private static int getCnt(int key) {
        int cnt = 1;
        int dist = arr[0];
        for (int i = 1; i < N; i++) {
            if (arr[i] - dist >= key) {
                cnt++;
                dist = arr[i];
            }
        }
        return cnt;
    }
}