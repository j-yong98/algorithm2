import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        long ans = 0;
        for (int l = 0; l < N - 2; l++) {
            int m = l + 1;
            int r = N - 1;
            while (m < r) {
                int sum = arr[l] + arr[m] + arr[r];
                if (sum == 0) {
                    int a = arr[m];
                    int b = arr[r];
                    if (arr[m] == arr[r]) {
                        ans += ((long) (r - m + 1) * (r - m)) / 2;
                        break;
                    } else {
                        int dm = 0;
                        int dr = 0;
                        while (arr[m] == a) {
                            m++;
                            dm++;
                        }
                        while (arr[r] == b) {
                            r--;
                            dr++;
                        }
                        ans += (long) dm * dr;
                    }
                } else if (sum < 0) {
                    m++;
                } else {
                    r--;
                }
            }
        }
        System.out.println(ans);
    }
}