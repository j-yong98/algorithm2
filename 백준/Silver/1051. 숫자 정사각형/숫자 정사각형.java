import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;
    /**
     * 숫자 정사각형
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++)
                arr[i][j] = line.charAt(j) - '0';
        }
        int ans = 0;
        for (int k = 0; k < Math.max(N, M); k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (i + k >= N || j + k >= M) continue;
                    int a = arr[i][j];
                    int b = arr[i][j + k];
                    int c = arr[i + k][j];
                    int d = arr[i + k][j + k];
                    if (a == b && b == c && c == d)
                        ans = Math.max(ans, k + 1);
                }
            }
        }
        System.out.println(ans * ans);
        br.close();
    }
}