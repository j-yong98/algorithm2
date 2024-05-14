import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr = new int[10];
    static int[] pick = new int[10];
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        f(0, 0);
        System.out.println(ans);
    }

    private static void f(int l, int sum) {
        if (l == 10) {
            if (sum >= 5) ans++;
            return;
        }

        for (int i = 1; i <= 5; i++) {
            if (l > 1 && pick[l - 1] == i && i == pick[l - 2]) continue;
            pick[l] = i;
            f(l + 1, arr[l] == pick[l] ? sum + 1 : sum);
        }
    }
}