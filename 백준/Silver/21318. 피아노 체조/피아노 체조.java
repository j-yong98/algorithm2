import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static int Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] temp = new int[N + 1];
        for (int i = 1; i < N; i++) {
            if (arr[i] > arr[i + 1]) {
                temp[i] = 1;
            }
        }
        for (int i = 1; i <= N; i++) {
            temp[i] += temp[i - 1];
        }
        StringBuilder sb = new StringBuilder();
        Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(temp[y - 1] - temp[x - 1]).append("\n");
        }
        System.out.println(sb);
    }

}
