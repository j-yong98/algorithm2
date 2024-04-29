import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    /**
     * 골뱅이 찍기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        char[][] arr = new char[N * 5][N * 5];
        for (int i = 0; i < N * 5; i++) {
            for (int j = 0; j < N * 5; j++) {
                if (i >= N && i < 4 * N && j >= N && j < 4 * N) {
                    arr[i][j] = ' ';
                } else {
                    arr[i][j] = '@';
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N * 5; i++) {
            for (int j = 0; j < N * 5; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}