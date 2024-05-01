import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static final int BLANK = 0;
    static final int WALL = 6;
    static final int ACCESS = 7;
    static int n;
    static int m;
    static int[][] arr;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int ans = Integer.MAX_VALUE;
    static List<int[]> list = new ArrayList<>();
    static List<Stack> s_list = new ArrayList<>();
    private static int checkMap() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == BLANK)
                    cnt++;
            }
        }
        return cnt;
    }
    private static boolean inRange(int y, int x) {
        return (y >= 0 && y < n && x >= 0 && x < m);
    }

    private static void count(int y, int x, int dir, int num) {
        int yy = y + dy[dir];
        int xx = x + dx[dir];
        if (inRange(yy, xx) && (arr[yy][xx] != WALL)) {
            if (arr[yy][xx] == BLANK) {
                arr[yy][xx] = ACCESS;
                s_list.get(num).add(new int[]{yy, xx});
            }
            count(yy, xx, dir, num);
        }
    }

    private static void recall(int num) {
        Stack<int[]> s = s_list.get(num);
        while (!s.isEmpty()) {
            int[] pos = s.pop();
            arr[pos[0]][pos[1]] = BLANK;
        }
    }

    private static void display(int y, int x, int dir, int val, int num) {
        if (val == 1)
            count(y, x, dir, num);
        if (val == 2) {
            count(y, x, dir, num);
            count(y, x, (dir + 2) % 4, num);
        }
        if (val == 3) {
            count(y, x, dir, num);
            count(y, x, (dir + 1) % 4, num);
        }
        if (val == 4) {
            count(y, x, dir, num);
            count(y, x, (dir + 1) % 4, num);
            count(y, x, (dir + 2) % 4, num);
        }
        if (val == 5) {
            count(y, x, dir, num);
            count(y, x, (dir + 1) % 4, num);
            count(y, x, (dir + 2) % 4, num);
            count(y, x, (dir + 3) % 4, num);
        }
    }
    private static void simulate(int num) {
        if (num == list.size()) {
            int cnt = checkMap();
            if (ans > cnt)
                ans = cnt;
            return ;
        }
        int y = list.get(num)[0];
        int x = list.get(num)[1];
        for (int i = 0; i < 4; i++) {
            display(y, x, i, arr[y][x], num);
            simulate(num + 1);
            recall(num);
        }
    }

    /**
     * 감시
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] >= 1 && arr[i][j] <= 5)
                    list.add(new int[]{i, j});
            }
        }
        for (int i = 0; i < list.size(); i++) {
            s_list.add(new Stack());
        }
        simulate(0);
        System.out.println(ans);
    }
}
