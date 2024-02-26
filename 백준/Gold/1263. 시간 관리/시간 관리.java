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
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            arr[i] = new int[]{t, s};
        }
        Arrays.sort(arr, (a, b) -> -Integer.compare(a[1], b[1]));
        int cur = arr[0][1];
        for (int i = 0; i < N; i++) {
            cur = Math.min(cur, arr[i][1]) - arr[i][0];
        }
        System.out.println(cur < 0 ? -1 : cur);
        br.close();
    }
}