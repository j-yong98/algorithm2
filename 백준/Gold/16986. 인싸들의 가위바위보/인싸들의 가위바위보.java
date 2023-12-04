
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static boolean w = false;
    static boolean[] checked;
    static int[][] compatibility;
    static int[][] users = new int[4][21];

    private static int getRes(int cmd1, int cmd2, int p1, int p2) {
        if (compatibility[cmd1][cmd2] == 2)
            return p1;
        else if (compatibility[cmd1][cmd2] == 1)
            return Math.max(p1, p2);
        else return p2;
    }

    private static void canWin() {
        int[] idx = new int[4];
        for (int i = 1; i <= 3; i++)
            idx[i] = 1;
        int[] score = new int[4];
        int p1 = 1;
        int p2 = 2;
        int nextPlayer;
        while (true) {
            nextPlayer = 6 - (p1 + p2);
            if (score[1] == k) {
                w = true;
                return;
            } else if (score[2] == k || score[3] == k)
                return;
            if (idx[1] == n + 1 || idx[2] == 21 || idx[3] == 21)
                return;
            int cmd1 = users[p1][idx[p1]];
            int cmd2 = users[p2][idx[p2]];
            int res = getRes(cmd1, cmd2, p1, p2);
            score[res]++;
            idx[p1]++;
            idx[p2]++;
            p1 = res;
            p2 = nextPlayer;
        }
    }

    private static void comb(int l) {
        if (w)
            return;
        if (l == n + 1) {
            canWin();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!checked[i]) {
                checked[i] = true;
                users[1][l] = i;
                comb(l + 1);
                if (w)
                    return;
                checked[i] = false;
            }
        }
    }

    /**
     * 인싸들의 가위바위보
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        compatibility = new int[n + 1][n + 1];
        checked = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++)
                compatibility[i][j] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 20; i++)
            users[2][i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 20; i++)
            users[3][i] = Integer.parseInt(st.nextToken());
        comb(1);
        System.out.println(w ? 1 : 0);
    }
}
