import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        long ans = 0;
        if (N == 1) {
            ans += getFiveSide();
        } else if (N == 2) {
            ans += getTwoSide() * 4;
            ans += getThreeSide() * 4;
        } else {
            ans += 4 * getThreeSide();
            ans += ((long) 8 * N - 12) * getTwoSide();
            ans += (long) (5 * Math.pow(N, 2) - (long) 16 * N + 12) * getOneSide();
        }
        System.out.println(ans);
    }

    private static long getOneSide() {
        int min = Arrays.stream(arr).min().getAsInt();
        return min;
    }

    private static long getTwoSide() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                if (i + j == 5) continue;
                min = Math.min(min, arr[i] + arr[j]);
            }
        }
        return min;
    }

    private static long getThreeSide() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                if (i + j == 5) continue;
                for (int k = j + 1; k < 6; k++) {
                    if (i + k == 5 || k + j == 5) continue;
                    min = Math.min(min, arr[i] + arr[j] + arr[k]);
                }
            }
        }
        return min;
    }

    private static long getFiveSide() {
        int sum = Arrays.stream(arr).sum();
        int max = Arrays.stream(arr).max().getAsInt();
        return sum - max;
    }
}