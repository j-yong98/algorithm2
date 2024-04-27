import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static int[][] arr;

    /**
     * 인명구조원
     */
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][];
        for (int i = 0; i < N; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            arr[i] = new int[]{s, e};
        }
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        int ans = 0;
        for (int i = 0; i < N; i++) {   //제외할 사람
            int time = 0;
            int[] cur = null;
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }

                if (cur == null) {
                    cur = new int[]{arr[j][0], arr[j][1]};
                } else {
                    if (cur[1] >= arr[j][0]) {
                        cur[1] = arr[j][1];
                    } else {
                        time += cur[1] - cur[0];
                        cur = new int[]{arr[j][0], arr[j][1]};
                    }
                }
            }
            time += cur[1] - cur[0];
            ans = Math.max(ans, time);
        }
        System.out.println(ans);
    }
}