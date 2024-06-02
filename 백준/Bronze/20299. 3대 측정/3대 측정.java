import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, K, L;
    /**
     * 3대 측정
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[3];
            boolean flag = true;
            for (int j = 0; j < 3; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                if (arr[j] < L) {
                    flag = false;
                }
            }
            int sum = Arrays.stream(arr).sum();
            if (sum >= K && flag) {
                cnt++;
                Arrays.stream(arr).forEach(value -> sb.append(value).append(" "));
            }
        }
        sb.insert(0, "\n");
        sb.insert(0, cnt);
        System.out.println(sb);
        br.close();
    }
}