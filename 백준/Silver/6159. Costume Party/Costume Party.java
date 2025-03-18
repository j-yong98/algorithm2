import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, S;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int cnt = 0;
        for (int i = 1; i < N; i++) {
            int j = i - 1;
            while (j >= 0 && arr[i] + arr[j] > S) {
                j--;
            }
            if (j < 0) {
                continue;
            }
            cnt += (j + 1);
        }
        System.out.println(cnt);
    }
}