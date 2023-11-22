import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static List<Integer>[] favorites;
    static int[][] classroom;

    /**
     * 상어 초등학교
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        classroom = new int[n][n];
        favorites = new List[n * n + 1];
        for (int i = 1; i <= n * n; i++) {
            favorites[i] = new ArrayList<>();
        }
        for (int i = 0; i < n * n; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 4; j++)
                favorites[idx].add(Integer.valueOf(st.nextToken()));
            findSuiteSeat(idx);
        }
        System.out.println(getScore());
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }

    private static int[] isBest(int idx, int y, int x) {
        int friends = 0;
        int blank = 0;
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        for (int i = 0; i < 4; i++) {
            int yy = y + dy[i];
            int xx = x + dx[i];
            for (int j = 0; j < favorites[idx].size(); j++) {
                if (inRange(yy, xx) && classroom[yy][xx] == favorites[idx].get(j))
                    friends++;
                else if (inRange(yy, xx) && classroom[yy][xx] == 0)
                    blank++;
            }
        }
        return new int[]{friends, blank};
    }

    private static void findSuiteSeat(int idx) {
        int best = -1;
        int blankBest = -1;
        int[] pos = new int[]{-1, -1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (classroom[i][j] == 0) {
                    int[] friendAndBlankSeat = isBest(idx, i, j);
                    if (friendAndBlankSeat[0] > best) {
                        best = friendAndBlankSeat[0];
                        blankBest = friendAndBlankSeat[1];
                        pos[0] = i;
                        pos[1] = j;
                    } else if (friendAndBlankSeat[0] == best) {
                        if (friendAndBlankSeat[1] > blankBest) {
                            best = friendAndBlankSeat[0];
                            blankBest = friendAndBlankSeat[1];
                            pos[0] = i;
                            pos[1] = j;
                        }
                    }
                }
            }
        }
        classroom[pos[0]][pos[1]] = idx;
    }
    private static int[][] getAdj() {
        int[][] adj = new int[n][n];
        int[] dy = new int[]{1, -1, 0, 0};
        int[] dx = new int[]{0, 0, 1, -1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int idx = classroom[i][j];
                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int yy = i + dy[d];
                    int xx = j + dx[d];
                    if (inRange(yy, xx)) {
                        for (int friend : favorites[idx]) {
                            if (friend == classroom[yy][xx])
                                cnt++;
                        }
                    }
                }
                adj[i][j] = cnt;
            }
        }
        return adj;
    }
    private static int getScore() {
        int[][] adj;
        int score = 0;
        adj = getAdj();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                score += adj[i][j] == 0 ? 0 : (int) Math.pow(10, adj[i][j] - 1);
        }
        return score;
    }
}
