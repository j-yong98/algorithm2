
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int AIR_CLEANER = -1;
    static final int BLANK = 0;
    static int r, c, t;
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};
    static int[][] arr;
    static int air;

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < r && x >= 0 && x < c;
    }

    private static void spread() {
        int[][] tmp = new int[r][c];
        tmp[air][0] = AIR_CLEANER;
        tmp[air + 1][0] = AIR_CLEANER;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == AIR_CLEANER || arr[i][j] == BLANK)
                    continue;
                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int y = i + dy[d];
                    int x = j + dx[d];
                    if (inRange(y, x) && arr[y][x] != AIR_CLEANER) {
                        tmp[y][x] += arr[i][j] / 5;
                        cnt++;
                    }
                }
                tmp[i][j] += arr[i][j] - (arr[i][j] / 5 * cnt);
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)
                arr[i][j] = tmp[i][j];
        }
    }

    private static void clear() {
        int[][] tmp = new int[r][c];
        tmp[air][0] = AIR_CLEANER;
        tmp[air + 1][0] = AIR_CLEANER;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)
                tmp[i][j] = arr[i][j];
        }
        int y = air;
        int x = 0;
        int d = 0;
        while(true) {
            int yy = y + dy[d];
            int xx = x + dx[d];
            if (!inRange(yy, xx)) {
                d++;
                yy = y + dy[d];
                xx = x + dx[d];
            }
            if (arr[yy][xx] == AIR_CLEANER)
                break ;
            tmp[yy][xx] = arr[y][x] == AIR_CLEANER ? 0 : arr[y][x];
            y = yy;
            x = xx;
        }
        y = air + 1;
        x = 0;
        d = 0;
        while (true) {
            int yy = y + dy[d];
            int xx = x + dx[d];
            if (!inRange(yy, xx)) {
                d = (d - 1 + 100) % 4;
                yy = y + dy[d];
                xx = x + dx[d];
            }
            if (arr[yy][xx] == AIR_CLEANER)
                break ;
            tmp[yy][xx] = arr[y][x] == AIR_CLEANER ? 0 : arr[y][x];
            y = yy;
            x = xx;
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)
                arr[i][j] = tmp[i][j];
        }
    }

    /**
     * 미세먼지 안녕!
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < r; i++) {
            if (arr[i][0] == AIR_CLEANER) {
                air = i;
                break;
            }
        }
        for (int T = 0; T < t; T++) {
            spread();
            clear();
        }
        int sum = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == AIR_CLEANER) continue;
                sum += arr[i][j];
            }
        }
        System.out.println(sum);
    }
}
