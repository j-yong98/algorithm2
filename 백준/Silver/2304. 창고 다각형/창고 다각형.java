import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] arr;

    /**
     * 창고 다각형
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        int area = 0;
        int[] left = new int[]{0, 0};
        for (int i = 0; i < N; i++) {
            if (left[1] <= arr[i][1]) {
                area += (arr[i][0] - left[0]) * left[1];
                left[0] = arr[i][0];
                left[1] = arr[i][1];
            }
        }
        area += left[1];

        int[] right = new int[]{0, 0};
        for (int i = N - 1; i >= 0; i--) {
            if (right[1] < arr[i][1]) {
                area += (right[0] - arr[i][0]) * right[1];
                right[0] = arr[i][0];
                right[1] = arr[i][1];
            }
        }
        System.out.println(area);
        br.close();
    }
}