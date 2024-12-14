import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static int A;

    /**
     * 줄줄이 박수
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[j] += Integer.parseInt(st.nextToken());
            }
        }
        A = Integer.parseInt(br.readLine());
        int max = 0;
        for (int i = 0; i < M - A + 1; i++) {
            int sum = 0;
            for (int j = 0; j < A; j++) {
                sum += arr[i + j];
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);
        br.close();
    }
}