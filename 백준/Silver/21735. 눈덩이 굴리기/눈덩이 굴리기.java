import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static int ans = 0;
    /**
     * 눈덩이 굴리기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        f(0, 0, 1);
        System.out.println(ans);
        br.close();
    }

    private static void f(int n, int m, int snow) {
        if (n == N || m == M) {
            ans = Math.max(ans, snow);
            return;
        }

        // 한 칸만 움직이기
        f(n + 1, m + 1, snow + arr[n + 1]);

        // 두 칸 움직이기
        if (n + 2 <= N) {
            f(n + 2, m + 1, (snow >> 1) + arr[n + 2]);
        }
    }
}