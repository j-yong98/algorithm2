import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, H;
    static int[] arr;
    static int[][] cnt;

    //짝수면 석순(아래-> 위), 홀수면 종유석(위 -> 아래)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[N];
        cnt = new int[2][H + 1];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                cnt[0][arr[i]]++;
            } else {
                cnt[1][H - arr[i] + 1]++;
            }
        }

        for (int i = H - 1; i >= 1; i--) {
            cnt[0][i] += cnt[0][i + 1];
        }

        for (int i = 1; i <= H; i++) {
            cnt[1][i] += cnt[1][i - 1];
        }

        int min = Integer.MAX_VALUE;
        int c = 0;
        for (int i = 1; i <= H; i++) {
            int sum = cnt[0][i] + cnt[1][i];
            if (sum < min) {
                min = sum;
                c = 1;
            } else if (sum == min) {
                c++;
            }
        }
        System.out.println(min + " " + c);
    }
}

