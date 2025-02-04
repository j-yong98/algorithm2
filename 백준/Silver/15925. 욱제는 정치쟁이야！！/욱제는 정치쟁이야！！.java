import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int[][] arr;
    static boolean flag = false;
    /**
     * 옥제는 정치쟁이야
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        f();
        f();

        for (int i =0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] != S) {
                    System.out.println(0);
                    return;
                }
            }
        }
        System.out.println(1);
        br.close();
    }

    private static void f() {
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == S) {
                    cnt++;
                }
            }
            if (cnt > (N >> 1)) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = S;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (arr[j][i] == S) {
                    cnt++;
                }
            }
            if (cnt > (N >> 1)) {
                for (int j = 0; j < N; j++) {
                    arr[j][i] = S;
                }
            }
        }
    }

}