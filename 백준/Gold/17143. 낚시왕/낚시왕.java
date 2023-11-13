import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Shark {
        int s;
        int d;
        int z;

        public Shark(int s, int d, int z) {
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
    static Shark[][] arr;
    static int r, c, m;
    static int pos = 0;
    static int ans = 0;

    private static void catchShark() {
        for (int i = 1; i <= r; i++) {
            if (arr[i][pos] != null) {
                ans += arr[i][pos].z;
                arr[i][pos] = null;
                return ;
            }
        }
    }
    private static boolean inRange(int y, int x) {
        return y >= 1 && y <= r && x >= 1 && x <= c;
    }
    private static int[] move(int y, int x) {
        Shark s = arr[y][x];
        int[] dy = {0, -1, 1, 0, 0};
        int[] dx = {0, 0, 0, 1, -1};
        for (int i = 0; i < s.s; i++) {
            int yy = y + dy[s.d];
            int xx = x + dx[s.d];
            if (!inRange(yy, xx)) {
                if (s.d == 1 || s.d == 3)
                    s.d += 1;
                else if (s.d == 2 || s.d == 4)
                    s.d -= 1;
                yy = y + dy[s.d];
                xx = x + dx[s.d];
            }
            y = yy;
            x = xx;
        }
        return new int[]{y, x};
    }
    private static void moveShark() {
        Shark[][] tmp = new Shark[r + 1][c + 1];
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (arr[i][j] != null) {
                    int[] pos = move(i, j);
                    if (tmp[pos[0]][pos[1]] != null) {
                        if (tmp[pos[0]][pos[1]].z < arr[i][j].z)
                            tmp[pos[0]][pos[1]] = arr[i][j];
                    }
                    else tmp[pos[0]][pos[1]] = arr[i][j];
                }
            }
        }
        arr = tmp;
    }
    private static void fishing() {
        while (++pos <= c) {
            catchShark();//상어 잡기
            moveShark();//상어 이동
        }
    }
    /**
     * 낚시왕
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new Shark[r + 1][c + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            arr[y][x] = new Shark(s, d, z);
        }
        fishing();
        System.out.println(ans);
    }
}
