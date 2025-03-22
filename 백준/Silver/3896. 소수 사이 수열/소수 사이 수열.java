import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {
    static final int MAX = 1_300_000;
    static List<Integer> list = new ArrayList<>();
    static boolean[] isPrime = new boolean[MAX + 1];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 2; i <= Math.sqrt(MAX); i++) {
            if (isPrime[i]) continue;
            for (int j = i * i; j <= MAX; j+=i) {
                isPrime[j] = true;
            }
        }
        for (int i = 2; i <= MAX; i++) {
            if (!isPrime[i]) list.add(i);
        }
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int l = lower(k);
            if (list.get(l) != k) {
                l--;
            }
            int r = lower(k);
            sb.append(list.get(r) - list.get(l)).append("\n");
        }
        System.out.println(sb);
    }

    private static int lower(int k) {
        int l = 0;
        int r = list.size();

        while (l < r) {
            int mid = (l + r) >> 1;

            if (list.get(mid) < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }
}