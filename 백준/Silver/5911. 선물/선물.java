import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, B;
    static int[][] arr;

    /**
     * 선물
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        arr = new int[N][];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            arr[i] = new int[]{p, s};
        }
        Arrays.sort(arr, (a, b) -> a[0] + a[1] == b[0] + b[1] ? a[1] == b[1] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]) : Integer.compare(a[0] + a[1], b[0] + b[1]));
        int cnt = 0;
        long max = 0;
        for (int i = 0; i < N; i++) {
            int val1 = arr[i][0] + arr[i][1];
            if (val1 <= B) {
                cnt++;
                max = Math.max(max, arr[i][0]);
                B -= val1;
            } else {
                max = Math.max(max, arr[i][0]);
                if (B + max / 2 >= val1) {
                    cnt++;
                }
                break;
            }
        }
        System.out.println(cnt);
        br.close();
    }

}