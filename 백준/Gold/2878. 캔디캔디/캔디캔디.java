import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;

    /**
     * 캔디캔디
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        long cnt = -M;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            cnt += arr[i];
        }

        Arrays.sort(arr);
        long ans = 0;
        for (int i = 0; i < N; i++) {
            long d = Math.min(arr[i], cnt / (N - i));
            ans += d * d;
            cnt -= d;
        }
        System.out.println(ans);
        br.close();
    }

    /**
     * 총 사탕 수, 각 사람이 받고 싶은 사탕 수는 정해져 있다.
     * 이를 통해 못주는 사탕의 개수를 구하고 이를 잘 배분해주면 된다.
     * 사탕을 많이 받고 싶어하는 사람에게 더 많은 사탕이 가도록 하면 된다.
     */
}