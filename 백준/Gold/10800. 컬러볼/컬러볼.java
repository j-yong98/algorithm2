import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 2000;
    static int N;
    static int[][] arr;
    static int[] color;
    static int[] size = new int[MAX + 1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][];
        color = new int[N + 1];
        arr[0] = new int[]{0, 0};
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            arr[i] = new int[]{c, s, i};
        }
        Arrays.sort(arr, 1, N + 1, (a, b) -> a[1] == b[1] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        int[] ans = new int[N + 1];
        int sum = 0;
        for (int i = 1; i <= N; i++) {

            // 현재까지 총 값 - 같은 색인 경우 - 같은 사이즈
            ans[arr[i][2]] = sum - color[arr[i][0]] - size[arr[i][1]];

            sum += arr[i][1];
            color[arr[i][0]] += arr[i][1];
            size[arr[i][1]] += arr[i][1];

            if (arr[i - 1][0] == arr[i][0] && arr[i - 1][1] == arr[i][1]) {
                ans[arr[i][2]] = ans[arr[i - 1][2]];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(ans[i]).append("\n");
        }
        System.out.println(sb);
    }

}