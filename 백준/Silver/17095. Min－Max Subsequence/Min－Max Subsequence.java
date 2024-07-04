import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static List<Integer> a = new ArrayList<>();
    static List<Integer> b = new ArrayList<>();

    /**
     * Min-Max Subsequence
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            arr[i] = val;
        }

        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = N - 1; i >= 0; i--) {
            if (max <= arr[i]) {
                max = arr[i];
                maxIdx = i;
            }
            if (min >= arr[i]) {
                min = arr[i];
                minIdx = i;
            }
            a.add(maxIdx);
            b.add(minIdx);
        }

        int ans = Integer.MAX_VALUE;
        int temp = 0;
        for (int i = 0; i < N; i++) {
            int res = Math.abs(arr[a.get(i)] - arr[b.get(i)]);
            int len = Math.abs(a.get(i) - b.get(i)) + 1;
            if (temp < res) {
                ans = len;
                temp = res;
            } else if (temp == res) {
                ans = Math.min(ans, len);
            }
        }
        System.out.println(ans);
    }
}