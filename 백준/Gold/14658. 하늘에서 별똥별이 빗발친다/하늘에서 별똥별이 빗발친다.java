import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, L, K;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[K][];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new int[]{x, y};
        }

        int res = 0;
        //100^3
        for (int[] p1 : arr) {
            for (int[] p2 : arr) {
                int cnt = 0;
                for (int[] p3 : arr) {
                    if (check(p1[0], p3[0]) || check(p2[1], p3[1])) continue;
                    cnt++;
                }
                res = Math.max(res, cnt);
            }
        }
        System.out.println(K - res);
    }

    private static boolean check(int p1, int p2) {
        return p1 > p2 || p2 > p1 + L;
    }
}

