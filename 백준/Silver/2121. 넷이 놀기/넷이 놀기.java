import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int A, B;
    static int[][] arr;
    /**
     * 넷이 놀기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        int ans = 0;
        for (int i = 0; i < N; i++) {
            /**
             * 찾아야할게
             * x + A, y
             * x, y + B
             * x + A, y + B
             */

            if (can(arr[i][0] + A, arr[i][1]) && can(arr[i][0], arr[i][1] + B) && can(arr[i][0] + A, arr[i][1] + B)) {
                ans++;
            }
        }
        System.out.println(ans);
        br.close();
    }

    private static boolean can(int x, int y) {
        int l = 0;
        int r = N - 1;

        while (l <= r) {
            int m = (l + r) >> 1;

            if (arr[m][0] == x && arr[m][1] == y) {
                return true;
            } else if (arr[m][0] < x || (arr[m][0] == x && arr[m][1] < y)) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return false;
    }

}