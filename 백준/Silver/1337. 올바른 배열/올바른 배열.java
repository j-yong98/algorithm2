import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int k = 0;
            int cnt = 0;
            for (int j = arr[i]; j < arr[i] + 5; j++) {
                if (i + k < N && j == arr[i + k]) {
                    k++;
                } else {
                    cnt++;
                }
            }
            ans = Math.min(ans, cnt);
        }
        System.out.println(ans);
    }

}