import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static final int N = 5;
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};
    static String[][] arr = new String[N][N];
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().split(" ");
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                f(1, i, j, arr[i][j]);
            }
        }
        System.out.println(set.size());
    }

    private static void f(int cnt, int y, int x, String str) {
        if (cnt == 6) {
            set.add(str);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int yy = y + dy[i];
            int xx = x + dx[i];
            if (!inRange(yy, xx)) {
                continue;
            }
            f(cnt + 1, yy, xx, str + arr[yy][xx]);
        }
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }

}