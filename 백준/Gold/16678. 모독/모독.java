import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        long ans = 0;
        int idx = 1;
        for (int i = 0; i < N; i++) {
            if (idx > arr[i]) {
                continue;
            }
            ans += arr[i] - idx++;
        }
        System.out.println(ans);
    }
}