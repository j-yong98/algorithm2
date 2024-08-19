import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 1_000_000;
    static int T;
    static int A, B;
    static boolean[] checked = new boolean[MAX + 1];
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i < 10; i++) {
            f(i, false, false);
        }
        Collections.sort(list);
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            int l = lower(A);
            int u = upper(B);
            sb.append(u - l).append("\n");
        }
        System.out.print(sb);
    }

    private static void f(int n, boolean flag1, boolean flag2) {
        if (n > MAX) {
            return;
        }
        if (n >= 1) {
            if (flag1 && flag2) {
                list.add(n);
            }
        }
        int prev = n % 10;
        if (!flag2) {
            for (int i = prev + 1; i < 10; i++) {
                f(n * 10 + i, true, false);
            }
        }
        if (flag1) {
            for (int i = prev - 1; i >= 0; i--) {
                f(n * 10 + i, true, true);
            }
        }
    }

    private static int lower(int num) {
        int l = 0;
        int r = list.size();

        while (l < r) {
            int mid = (l + r) >> 1;

            if (list.get(mid) < num) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }

    private static int upper(int num) {
        int l = 0;
        int r = list.size();

        while (l < r) {
            int mid = (l + r) >> 1;

            if (list.get(mid) <= num) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }
}