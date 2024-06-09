import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static int K, N;
    static int[][] arr;
    static int[][] temp;

    /**
     * 카누 선수 N = 1000
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            arr = new int[4][N];
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            temp = new int[2][N * N];
            int idx = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    temp[0][idx] = arr[0][i] + arr[1][j];
                    temp[1][idx] = arr[2][i] + arr[3][j];
                    idx++;
                }
            }

            Arrays.sort(temp[0]);
            Arrays.sort(temp[1]);

            int ans = Integer.MAX_VALUE;
            for (int val : temp[0]) {
                int target = K - val;

                int l = 0;
                int r = temp[1].length - 1;
                int res = 0;
                int diff = Integer.MAX_VALUE;

                while (l <= r) {
                    int mid = (l + r) >> 1;

                    int v = temp[1][mid];
                    int abs = Math.abs(target - v);
                    if (v == target) {
                        res = v;
                        break;
                    }
                    else if (v < target) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }

                    if (abs < diff) {
                        res = v;
                        diff = abs;
                    } else if (abs == diff) {
                        res = Math.min(res, v);
                    }
                }

                int a = Math.abs(res + val - K);
                int b = Math.abs(ans - K);
                if (a < b) {
                    ans = res + val;
                } else if (a == b) {
                    ans = Math.min(res + val, ans);
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}