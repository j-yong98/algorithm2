import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        Arrays.sort(arr);
        int ansIdx = 0;
        int ansValue = 0;
        for (int i = min; i <= max; i++) {
            int value = 0;
            int cnt = 0;
            for (int j = M - 1; j >= 0; j--) {
                if (cnt == N) {
                    break;
                }
                if (arr[j] >= i) {
                    value += i;
                    cnt += 1;
                }
            }
            if (ansValue < value) {
                ansIdx = i;
                ansValue = value;
            }
        }
        System.out.println(ansIdx + " " + ansValue);
        br.close();
    }
}