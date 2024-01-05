import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static final int SIZE = 10;
    static int T;
    static int[] arr = new int[SIZE];
    static boolean[] checked = new boolean[SIZE];
    static int use = 0;
    static List<char[]> strs = new ArrayList<>();
    static long ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            char[] str = br.readLine().toCharArray();
            strs.add(str);
            for (int j = 0; j < str.length; j++) {
                checked[str[j] - 'A'] = true;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (checked[i]) {
                use += 1;
            }
        }
        make(0, 0, 0);
        System.out.println(ans);
    }

    private static void make(int l, int idx, int visited) {
        if (l == use) {
            long result = calc();
            ans = Math.max(ans, result);
            return;
        }
        if (!checked[idx]) {
            make(l, idx + 1, visited);
        } else {
            for (int i = 9; i >= 0; i--) {
                if ((visited & (1 << i)) != 0) continue;
                arr[idx] = i;
                make(l + 1, idx + 1, visited | (1 << i));
            }
        }
    }

    private static long calc() {
        long sum = 0;
        for (char[] str : strs) {
            long result = makeNum(str);
            if (result == -1) return -1;
            sum += result;
        }
        return sum;
    }

    private static long makeNum(char[] str) {
        if (arr[str[0] - 'A'] == 0) return -1;
        long num = 0;
        for (int i = 0; i < str.length; i++) {
            num *= 10;
            num += arr[str[i] - 'A'];
        }
        return num;
    }
}