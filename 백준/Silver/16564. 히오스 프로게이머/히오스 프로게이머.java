import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N, K;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            min = Math.min(min, arr[i]);
        }

        long l = min;
        long r = Integer.MAX_VALUE;

        while (l <= r) {
            long mid = (l + r) >> 1;

            long k = getK(mid);
            if (k == K) {
                System.out.println(mid);
                return;
            }
            if (k < K) { // k(최소 레벨) > K 이 너무 높다 => 많은 이들의 레벨을 올려야한다.
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(r);
    }

    private static long getK(long low) {
        long ret = 0;
        for (int i = 0; i < N; i++) {
            long m = Math.max(0, low - arr[i]);
            ret += m;
        }
        return ret;
    }

}