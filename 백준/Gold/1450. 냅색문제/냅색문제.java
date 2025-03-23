import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static final int MAX = 1_000_000_000;
    static int N, C;
    static int[] arr;
    static List<Long> a = new ArrayList<>();
    static List<Long> b = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        f(0, N / 2, 0, a);
        f(N / 2, N, 0, b);


        a.sort(Long::compare);
        b.sort(Long::compare);

        long sum = 0;
        for (int i = 0; i < a.size(); i++) {
            long k = (long) C - a.get(i);
            if (k < 0) break;
            int u = upper(k, b);
            sum += u;
        }
        System.out.println(sum);
    }

    private static int upper(long k, List<Long> list) {
        int l = 0;
        int r = list.size() - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (list.get(mid) > k)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }

    private static void f(int n, int e, long sum, List<Long> list) {
        if (n == e) {
            list.add(sum);
            return;
        }

        f(n + 1, e, sum + arr[n], list);
        f(n + 1, e, sum, list);
    }
}