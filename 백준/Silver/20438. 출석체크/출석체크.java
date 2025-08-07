import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, Q, M;
    static boolean[] sleep;
    static boolean[] received;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sleep = new boolean[N + 3];
        received = new boolean[N + 3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(st.nextToken());
            sleep[num] = true;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (sleep[num]) continue;
            for (int j = num; j <= N + 2; j += num) {
                received[j] = true;
            }
        }
        int[] arr = new int[N + 3];
        for (int i = 3; i <= N + 2; i++) {
            arr[i] = arr[i - 1];
            if (!sleep[i] && received[i]) {
                arr[i]++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append((e - s + 1) - (arr[e] - arr[s - 1])).append("\n");
        }
        System.out.print(sb);
    }

}
