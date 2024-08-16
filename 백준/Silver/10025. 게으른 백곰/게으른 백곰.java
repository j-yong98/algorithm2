import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 1_000_000;
    static int N, K;
    static int[] arr = new int[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr[x] = g;
        }
        if (2 * K >= MAX) {
            System.out.println(Arrays.stream(arr).sum());
            return;
        }
        int sum = 0;
        for (int i = 0; i <= 2 * K; i++) {
            sum += arr[i];
        }

        int ans = sum;
        for (int i = 1; i < MAX - (2 * K); i++) {
            sum -= arr[i - 1];
            sum += arr[i + 2 * K];
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);
    }

}