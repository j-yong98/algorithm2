import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 200_000_000;
    static int T;
    static int N;
    static int[] arr;

    /**
     * 문제이름
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int ans = 0;
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    int diff = Math.abs(arr[i] - arr[j]);
                    int l = 0;
                    int r = N - 1;
                    while (l <= r) {
                        int m = (l + r) >> 1;
                        if (arr[m] == arr[j] + diff) {
                            ans += 1;
                            break;
                        }
                        if (arr[m] < arr[j] + diff) {
                            l = m + 1;
                        } else {
                            r = m - 1;
                        }
                    }
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}