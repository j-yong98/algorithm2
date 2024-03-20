import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] guilty;
    static int[][] R;
    static int mafia;
    static int ans;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        guilty = new int[N];
        R = new int[N][N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            guilty[i] = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                R[i][j] = Integer.parseInt(st.nextToken());
        }
        mafia = Integer.parseInt(br.readLine());
        ans = 0;
        dfs(N, 0, 0);
        System.out.println(ans);
        br.close();
    }

    private static void dfs(int living, int nightCnt, int dead) {
        if (flag) return;

        if (living == 1) {
            ans = Math.max(ans, nightCnt);
            flag = true;
            return;
        }

        if (living % 2 == 0) {
            for (int i = 0; i < N; i++) {
                if ((dead & (1 << i)) != 0) continue;
                if (i == mafia) continue;
                for (int j = 0; j < N; j++)
                    guilty[j] += R[i][j];
                dfs(living - 1, nightCnt + 1, dead | (1 << i));
                if (flag) return;
                for (int j = 0; j < N; j++)
                    guilty[j] -= R[i][j];
            }
        } else {
            int deadIdx = afternoon(dead);

            if (deadIdx == mafia) {
                ans = Math.max(ans, nightCnt);
                return;
            }

            dfs(living - 1, nightCnt, dead | (1 << deadIdx));
            if (flag) return;
        }
    }

    private static int afternoon(int dead) {
        int idx = -1;
        int max = 0;

        for (int i = 0; i < N; i++) {
            if ((dead & (1 << i)) != 0) continue;
            if (max < guilty[i]) {
                max = guilty[i];
                idx = i;
            }
        }
        return idx;
    }
}