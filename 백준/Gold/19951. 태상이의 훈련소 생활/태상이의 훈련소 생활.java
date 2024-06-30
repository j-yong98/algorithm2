import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    /**
     * 태상이의 훈련소 생활
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] temp = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            temp[a] += k;
            temp[b] -= k;
        }
        for (int i = 1; i < N; i++) {
            temp[i] += temp[i - 1];
        }
        for (int i = 0; i < N; i ++) {
            arr[i] += temp[i];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}