import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[][] discount;
    static int ans = Integer.MAX_VALUE;

    /**
     * 물약 구매
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        discount = new int[N][N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken()) - 1;
                int d = Integer.parseInt(st.nextToken());
                discount[i][num] = d;
            }
        }
        f(0, 0, 0);
        System.out.println(ans);
        br.close();
    }

    private static void f(int l, int visited, int sum) {
        if (sum > ans) {
            return;
        }
        if (l == N) {
            ans = sum;
            return;
        }

        for (int i = 0; i < N; i++) {
            if ((visited & (1 << i)) != 0) {
                continue;
            }
            for (int j = 0; j < N; j++) {
                arr[j] -= discount[i][j];
            }
            f(l + 1, visited | (1 << i), sum + Math.max(arr[i], 1));
            for (int j = 0; j < N; j++) {
                arr[j] += discount[i][j];
            }
        }
    }
}