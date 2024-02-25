import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, C;
    static int M;
    static int[][] arr;
    static int[] town;
    /**
     * 택배
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        town = new int[N + 1];
        arr = new int[M][];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[i] = new int[]{s, e, c};
        }

        int ans = 0;
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));
        for (int i = 0; i < M; i++) {
            int[] tmp = arr[i];
            int max = 0;
            for (int j = tmp[0]; j < tmp[1]; j++) {
                max = Math.max(max, town[j]);
            }
            int capacity = Math.min(tmp[2], C - max);
            for (int j = tmp[0]; j < tmp[1]; j++) {
                town[j] += capacity;
            }
            ans += capacity;
        }
        System.out.println(ans);

        br.close();
    }
}