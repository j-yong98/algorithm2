import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
class Main {
    static int[] arr = new int[10];
    static int[] orders = new int[10];
    static int[] status = new int[4];
    static int[] idx = new int[4];
    static final int[][] map = {
        {0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40},
        {10, 13, 16, 19, 25},
        {20, 22, 24, 25},
        {30, 28, 27, 26, 25},
        {40, -1},
        {25, 30, 35, 40}
    };
    static int ans = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        perm(0);
        System.out.println(ans);
    }
    private static void perm(int l) {
        if (l == 10) {
            for (int i = 0; i < 4; i++) {
                status[i] = 0;
                idx[i] = 0;
            }
            ans = Math.max(ans, play());
            return ;
        }
        for (int i = 0; i < 4; i++) {
            orders[l] = i;
            perm(l + 1);
        }
    }
    private static int play() {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            if (map[status[orders[i]]][idx[orders[i]]] == -1)
                return 0;
            int res = move(orders[i], arr[i]);
            if (res == -1)
                return 0;
            sum += res;
        }
        return sum;
    }
    private static int move(int seq, int cnt) {
        int row = status[seq];
        int col = idx[seq];
        for (int i = 0; i < cnt; i++) {
            col++;
            if (map[row][col] == -1) {
                status[seq] = row;
                idx[seq] = col;
                break;
            }
            else if (map[row][col] == 25) {
                row = 5;
                col = 0;
            }
            else if (map[row][col] == 40) {
                row = 4;
                col = 0;
            }
        }
        if (map[row][col] == -1)
            return 0;
        if ((row == 0 || (row == 5 && col != 1)) && map[row][col] % 10 == 0) {
            row = map[row][col] / 10;
            col = 0;
        }
        for (int i = 0; i < 4; i++) {
            if (seq == i) continue;
            if (status[i] == row && idx[i] == col)
                return -1;
        }
        status[seq] = row;
        idx[seq] = col;
        return map[status[seq]][idx[seq]];
    }
}