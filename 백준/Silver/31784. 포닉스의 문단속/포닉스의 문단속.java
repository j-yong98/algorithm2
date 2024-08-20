import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = br.readLine().toCharArray();
        for (int i = 0; i < N; i++) {
            int temp = (26 - (arr[i] - 'A')) % 26;
            if (K - temp < 0) {
                continue;
            }
            arr[i] = 'A';
            K -= temp;
        }
        K %= 26;
        if (K > 0) {
            int ch = arr[N - 1] - 'A';
            arr[N - 1] = (char) ((ch + K) % 26);
            arr[N - 1] += 'A';
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]);
        }
        System.out.println(sb);
    }
}