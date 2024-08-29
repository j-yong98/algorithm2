import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 1_000_000;
    static int T;
    static int N, M;
    static int[] cnt = new int[MAX + 1];
    static int[] bro = new int[MAX + 1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init();
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int ans = 0;
            for (int i = 2; i < N; i++) {
                if (cnt[N] == cnt[i] && bro[i] >= M) {
                    ans++;
                }
            }
            sb.append("Case #").append(t + 1).append(": ").append(ans).append("\n");
        }
        System.out.print(sb);
    }

    private static void init() {
        for (int i = 2; i <= MAX; i++) {
            divisor(i);
        }
    }

    private static void divisor(int val) {
        bro[val] = Integer.MAX_VALUE;
        for (int i = 2; i <= Math.sqrt(val); i++) {
            if (val % i == 0) {
                bro[val] = Math.min(bro[val], i);
                if (i * i == val) {
                    cnt[val] += 1;
                } else {
                    cnt[val] += 2;
                }
            }
        }
        bro[val] = bro[val] == Integer.MAX_VALUE ? 0 : bro[val];
    }
}