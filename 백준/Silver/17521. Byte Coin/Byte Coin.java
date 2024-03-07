import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int N, W;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        long w = W;
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                long cnt = w / arr[i];
                w -= cnt * arr[i];
                w += cnt * arr[i + 1];
            }
        }
        System.out.println(w);
        br.close();
    }
}