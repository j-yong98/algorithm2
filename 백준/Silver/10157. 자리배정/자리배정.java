import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, 1, 0, -1};
    static int N, M;
    static int K;

    /**
     * 자리배정
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        if (K > N * M) {
            System.out.println(0);
        } else {
            int[][] arr = new int[N][M];
            int cur = 1;
            int dir = 0;
            int y = 0;
            int x = 0;
            while (true) {
                if (cur == K) {
                    System.out.println((y + 1) + " " + (x + 1));
                    return;
                }
                arr[y][x] = cur++;
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                if (!inRange(ny, nx) || arr[ny][nx] != 0) {
                    dir = (dir + 1) % 4;
                    ny = y + dy[dir];
                    nx = x + dx[dir];
                }
                y = ny;
                x = nx;
            }
        }
        br.close();
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}