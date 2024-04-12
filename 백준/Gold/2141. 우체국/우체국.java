import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][];
        long sum = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = new int[]{a, b};
            sum += b;
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        long result = 0;
        for (int i = 0; i < N; i++) {
            result += arr[i][1];
            if (result >= (sum + 1) / 2) {
                System.out.println(arr[i][0]);
                return;
            }
        }
    }
}

