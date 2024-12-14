import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 100_000;
    static int N;
    static int[][] arr;
    /**
     * 박스 포장
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i][0] = i;
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (a, b)-> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        int[] ans = new int[MAX + 1];
        Arrays.fill(ans, 1);
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    ans[arr[j][1]] = Math.max(ans[arr[j][1]], ans[arr[i][1]] + 1);
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= MAX; i++) {
            max = Math.max(max, ans[i]);
        }
        System.out.println(max);
        br.close();
    }

}