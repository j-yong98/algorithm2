import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int[] arr;
    static int idx = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            int u = upper(val);
            max = Math.max(max, u + 1);
            if (u == idx) {
                arr[idx++] = val;
            } else {
                arr[u] = val;
            }
        }
        System.out.println(max);
    }

    private static int upper(int k) {
        int l = 0;
        int r = idx;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (arr[mid] <= k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }
}