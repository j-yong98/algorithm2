import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int A, B, C, N;
    /**
     * 방 배정하기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        boolean flag = false;
        for (int i = 0; i <= N; i += A) {
            for (int j = 0; j <= N; j += B) {
                for (int k = 0; k <= N; k += C) {
                    if (i + j + k == N) {
                        flag = true;
                        break;
                    }
                }
                if (flag) break;
            }
            if (flag) break;
        }
        System.out.println(flag ? 1 : 0);
        br.close();
    }
}