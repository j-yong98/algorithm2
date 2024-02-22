import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int SIZE = 3;
    static final int[] dy = {0, -1, -1};
    static final int[] dx = {-1, -1, 0};
    static int M, N;
    static int[] arr;
    static int[][] ans;
    static int[] input = new int[SIZE];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[2 * M - 1];
        Arrays.fill(arr, 1);

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = input[0]; i < input[0] + input[1]; i++) {
                arr[i] += 1;
            }

            for (int i = input[0] + input[1]; i < arr.length; i++) {
                arr[i] += 2;
            }
        }

        int mid = (2 * M - 1) / 2;
        ans = new int[M][M];
        for (int i = M - 1; i > 0; i--) {
            ans[i][0] = arr[M - i - 1];
        }
        for (int i = 0; i < M; i++) {
            ans[0][i] = arr[i + mid];
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < M; j++) {
                int max = 0;
                for (int k = 0; k < 3; k++) {
                    int y = i + dy[k];
                    int x = j + dx[k];
                    max = Math.max(max, ans[y][x]);
                }
                ans[i][j] = max;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(ans[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}