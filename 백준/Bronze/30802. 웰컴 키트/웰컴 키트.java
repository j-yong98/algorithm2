import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /**
     * 웰컴 키트
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[6];
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int T, P;
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        int[] ans = new int[3];
        for (int i = 0; i < 6; i++) {
            ans[0] += arr[i] / T;
            if (arr[i] % T != 0) {
                ans[0]++;
            }
        }
        ans[1] = N / P;
        ans[2] = N % P;
        System.out.println(ans[0]);
        System.out.println(ans[1] + " " + ans[2]);
        br.close();
    }
}