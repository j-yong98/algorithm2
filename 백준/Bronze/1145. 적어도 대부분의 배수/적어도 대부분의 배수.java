import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr = new int[5];
    /**
     * 적어도 대부분의 배수
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int min = Arrays.stream(arr).min().getAsInt();
        int ans;
        for (int i = min; ; i++) {
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                if (i % arr[j] == 0) cnt++;
            }
            if (cnt >= 3) {
                ans = i;
                break;
            }
        }
        System.out.println(ans);
        br.close();
    }
}