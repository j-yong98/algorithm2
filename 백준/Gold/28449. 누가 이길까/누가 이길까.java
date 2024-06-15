import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr = new int[2][];
    /**
     * 누가 이길까
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr[0] = new int[N];
        arr[1] = new int[M];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 2; i++) {
            Arrays.sort(arr[i]);
        }
        long[] ans = new long[3];
        for (int i = 0; i < N; i++) {
            int u = upper(arr[0][i], arr[1]);
            int l = lower(arr[0][i], arr[1]);

            ans[0] += l;
            ans[1] += M - u;
            ans[2] += u - l;

        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
        br.close();
    }

    private static int upper(int key, int[] val) {
        int l = 0;
        int r = val.length;

        while (l < r) {
            int m = (l + r) >> 1;

            if (val[m] <= key) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return r;
    }

    private static int lower(int key, int[] val) {
        int l = 0;
        int r = val.length;

        while (l < r) {
            int m = (l + r) >> 1;

            if(val[m] < key) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return r;
    }
}