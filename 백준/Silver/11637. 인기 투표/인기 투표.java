import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] arr;

    /**
     * 인기 투표
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            int total = 0;
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
                total += arr[i];
            }
            int max = Arrays.stream(arr).max().getAsInt();
            int cnt = 0;
            int idx = -1;
            for (int i = 0; i < N; i++) {
                if (max == arr[i]) {
                    idx = i;
                    cnt += 1;
                }
            }
            if (cnt > 1) {
                sb.append("no winner").append("\n");
            } else if ((total >> 1) >= arr[idx]) {
                sb.append("minority winner ").append(idx + 1).append("\n");
            } else {
                sb.append("majority winner ").append(idx + 1).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}