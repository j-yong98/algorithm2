import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, L;
    static int[] arr;
    static int[][] pos;
    static boolean[] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        pos = new int[N][];
        arr = new int[M];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pos[i] = new int[]{x, y};
        }

        Arrays.sort(arr);
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int[] p = pos[i];
            if (binary(p)) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static boolean binary(int[] key) {
        int l = 0;
        int r = M;

        while (l < r) {
            int m = (l + r) >> 1;

            long dist = getDist(arr[m], key);
            if (dist <= L) {
                return true;
            }
            if (arr[m] <= key[0]) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return false;
    }

    private static long getDist(int x, int[] p) {
        return Math.abs(x - p[0]) + p[1];
    }

}

