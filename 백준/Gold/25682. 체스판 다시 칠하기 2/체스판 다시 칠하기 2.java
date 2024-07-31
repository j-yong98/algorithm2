import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] arr;
    static int[][] black, white;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0;j  < M; j++) {
                arr[i][j] = str.charAt(j) == 'B' ? 1 : 0;
            }
        }
        System.out.println(Math.min(getMin(0), getMin(1)));
    }

    private static int getMin(int val) {
        int[][] temp = new int[N + 1][M + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int v;
                if ((i + j) % 2 == 0) {
                    v = val == arr[i][j] ? 0 : 1;
                } else {
                    v = val != arr[i][j] ? 0 : 1;
                }
                temp[i + 1][j + 1] = temp[i][j + 1] + temp[i + 1][j] - temp[i][j] + v;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= N - K + 1; i++) {
            for (int j = 1; j <= M - K + 1; j++) {
                min = Math.min(min, temp[i + K - 1][j + K - 1] - temp[i + K - 1][j - 1] - temp[i - 1][j + K - 1] + temp[i - 1][j - 1]);
            }
        }
        return min;
    }
}