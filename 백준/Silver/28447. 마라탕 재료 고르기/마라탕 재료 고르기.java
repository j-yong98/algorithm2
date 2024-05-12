import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[][] arr;
    static int ans = Integer.MIN_VALUE;
    /**
     * 마라탕 재료 고르기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        f(0, 0);
        System.out.println(ans);
        br.close();
    }

    private static void f(int l, int visited) {
        if (l == K) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if ((visited & (1 << i)) == 0) continue;
                for (int j = i + 1; j < N; j++) {
                    if ((visited & (1 << j)) == 0) continue;
                    sum += arr[i][j];
                }
            }
            ans = Math.max(sum, ans);
            return;
        }
        for (int i = 0; i < N; i++) {
            if ((visited & (1 << i)) != 0) continue;
            f(l + 1, visited | (1 << i));
        }
    }
}