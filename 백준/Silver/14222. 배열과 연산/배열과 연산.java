import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] arr = new int[51];
    /**
     * 배열과 연산
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            arr[val]++;
        }
        int i;
        for (i = 1; i <= N; i++) {
            if (arr[i] > 0) {
                arr[i]--;
                continue;
            }
            int temp = i - K;
            while (temp > 0 && arr[temp] == 0) {
                temp -= K;
            }
            if (temp > 0 && arr[temp] > 0) {
                arr[temp]--;
            } else {
                break;
            }
        }
        if (i - 1 == N) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        br.close();
    }
}