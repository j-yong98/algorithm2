import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 5;
    static int N;
    static int[][] arr;
    static int ans = 0;
    /**
     * Team Selection
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][MAX];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < MAX; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        f(0, 0, new int[MAX]);
        System.out.println(ans);
        br.close();
    }

    private static void f(int l, int visited, int[] pick) {
        if (l == MAX) {
            boolean[] checked = new boolean[N];
            int score = 0;

            for (int pos : pick) {
                int idx = -1;
                int best = 0;
                for (int i = 0; i < N; i++) {
                    if (checked[i]) continue;
                    if (best < arr[i][pos]) {
                        idx = i;
                        best = arr[i][pos];
                    }
                }
                if (idx > -1) {
                    score += best;
                    checked[idx] = true;
                }
            }
            ans = Math.max(ans, score);
            return;
        }
        for (int i = 0; i < 5; i++) {
            if ((visited & (1 << i)) != 0) {
                continue;
            }
            pick[l] = i;
            f(l + 1, visited | (1 << i), pick);
        }
    }
}