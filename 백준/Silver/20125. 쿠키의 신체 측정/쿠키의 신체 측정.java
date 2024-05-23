import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int[] dy = {0, 0, 1, 0};
    static final int[] dx = {-1, 1, 0, 1};
    static final char PART = '*';
    static final char BLANK = '_';
    static int N;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        int[] heart = new int[2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    int y = i + dy[k];
                    int x = j + dx[k];
                    if (inRange(y, x) && arr[y][x] == PART) cnt++;
                }
                if (cnt == 4) {
                    heart = new int[]{i, j};
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(heart[0] + 1).append(" ").append(heart[1] + 1).append("\n");
        sb.append(getLength(heart[0], heart[1] - 1, 0, -1)).append(" ");
        sb.append(getLength(heart[0], heart[1] + 1, 0, 1)).append(" ");
        int waist = getLength(heart[0] + 1, heart[1], 1, 0);
        sb.append(waist).append(" ");
        heart[0] += waist;
        sb.append(getLength(heart[0] + 1, heart[1] - 1, 1, 0)).append(" ");
        sb.append(getLength(heart[0] + 1, heart[1] + 1, 1, 0)).append(" ");
        System.out.println(sb);
    }

    private static int getLength(int y, int x, int ddy, int ddx) {
        if (!inRange(y, x)) {
            return 0;
        }
        if (arr[y][x] == BLANK) {
            return 0;
        }
        int yy = y + ddy;
        int xx = x + ddx;
        return getLength(yy, xx, ddy, ddx) + 1;
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }
}