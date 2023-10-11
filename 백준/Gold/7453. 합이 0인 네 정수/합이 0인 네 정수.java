import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] A;
    static int[] B;
    static int[] C;
    static int[] D;
    static int[] sum1;
    static int[] sum2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];
        C = new int[N];
        D = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                if (j == 0)
                    A[i] = Integer.parseInt(st.nextToken());
                if (j == 1)
                    B[i] = Integer.parseInt(st.nextToken());
                if (j == 2)
                    C[i] = Integer.parseInt(st.nextToken());
                if (j == 3)
                    D[i] = Integer.parseInt(st.nextToken());
            }
        }
        sum1 = new int[N * N];
        sum2 = new int[N * N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum1[i * N + j] = A[i] + B[j];
                sum2[i * N + j] = C[i] + D[j];
            }
        }
        Arrays.sort(sum1);
        Arrays.sort(sum2);
        int l = 0;
        int r = N * N - 1;
        long ans = 0;
        while (l < N * N && r >= 0) {
            int sum = sum1[l] + sum2[r];
            if (sum < 0)
                l++;
            else if (sum > 0)
                r--;
            else {
                int cnt1 = 1;
                int cnt2 = 1;

                while (l + cnt1 < N * N && sum1[l] == sum1[l + cnt1])
                    cnt1++;

                while (r - cnt2 >= 0 && sum2[r] == sum2[r - cnt2])
                    cnt2++;

                ans += (long) cnt1 * cnt2;
                l += cnt1;
                r -= cnt2;
            }
        }
        System.out.println(ans);
    }
}