import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int[] arr;
    static List<Integer> a = new ArrayList<>();
    static List<Integer> b = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        f(0, 0, N >> 1, a);
        f(N >> 1, 0, N, b);

        a.sort(Integer::compare);
        b.sort(Integer::compare);

        long ans = 0;
        for (int i = 0; i < a.size(); i++) {
            int s = a.get(i);
            int l = lower(S - s, b);
            int r = upper(S - s, b);
            ans += r - l;
        }
        if (S == 0) ans--;
        System.out.println(ans);
    }

    private static int lower(int target, List<Integer> list) {
        int l = 0;
        int r = list.size();
        while (l < r) {
            int mid = (l + r) >> 1;
            if (list.get(mid) < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }
    private static int upper(int target, List<Integer> list) {
        int l = 0;
        int r = list.size();
        while (l < r) {
            int mid = (l + r) >> 1;
            if (list.get(mid) <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }

    private static void f(int n, int s, int e, List<Integer> list) {
        if (n == e) {
            list.add(s);
            return;
        }
        
        f(n + 1, s + arr[n], e, list);
        f(n + 1, s, e, list);
    }

}