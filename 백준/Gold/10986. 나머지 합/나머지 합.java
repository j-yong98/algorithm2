import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;
    static long[] sum;
    static int[] cnt;

    /**
     * 나머지 합
     * 누적 합의 나머지를 구한 후 2개를 선택하는 조합을 더 해주면 된다.
     * 이 때 2개를 선택하는 이유는
     * M = 3, 나머지 카운트 배열 : [2, 3, 0] 이라고 할 때
     * 나머지가 1인 애들 3개 1, 4, 7을 생각해보면 둘 사이의 차가 M의 배수가 된다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        sum = new long[N + 1];
        cnt = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + arr[i];
            cnt[(int) (sum[i] % M)]++;
        }
        long ans = cnt[0];
        for (int i = 0; i < M; i++) {
            long n = cnt[i];
            ans += (n * (n - 1)) / 2;
        }
        System.out.println(ans);
    }
}