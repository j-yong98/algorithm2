import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    /**
     * 같이 눈사람 만들래?
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = N - 1; j > i; j--) {
                int l = i + 1;
                int r = j - 1;
                int sum1 = arr[i] + arr[j];
                while (l < r) {
                    int sum2 = arr[l] + arr[r];

                    ans = Math.min(ans, Math.abs(sum2 - sum1));
                    if (sum1 == sum2) {
                        ans = 0;
                        break;
                    } else if (sum1 > sum2) {
                        l++;
                    } else {
                        r--;
                    }
                }
                if (ans == 0) {
                    break;
                }
            }
            if (ans == 0) {
                break;
            }
        }
        System.out.println(ans);
        br.close();
    }
}