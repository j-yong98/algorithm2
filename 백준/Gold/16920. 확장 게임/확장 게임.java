import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static final int[] dy = {-1, 0, 1, 0};
    static final int[] dx = {0, -1, 0, 1};
    static int n, m, p;
    static int[][] arr;
    static int[] dist;
    static Queue<int[]>[] castle;

    /**
     * 확장 게임
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        p = Integer.parseInt(line[2]);
        arr = new int[n][m];
        dist = new int[p + 1];
        castle = new Queue[p + 1];
        line = br.readLine().split(" ");
        for (int i = 1; i <= p; i++)
            castle[i] = new ArrayDeque<>();
        for (int i = 1; i <= p; i++)
            dist[i] = Integer.parseInt(line[i - 1]);

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                char ch = str.charAt(j);
                if (ch == '.') continue;
                if (ch == '#') arr[i][j] = -1;
                else {
                    arr[i][j] = ch - '0';
                    castle[arr[i][j]].add(new int[]{i, j, arr[i][j]});
                }
            }
        }
        while (true) {
            boolean flag = false;
            for (int i = 1; i <= p; i++) {
                boolean res = expand(castle[i], dist[i]);
                flag = flag ? flag : res;
            }
            if (!flag) break;
        }

        int[] ans = new int[p + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == -1) continue;
                ans[arr[i][j]] += 1;
            }
        }
        for (int i = 1; i <= p; i++)
            bw.write(ans[i] + " ");
        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean expand(Queue<int[]> q, int maxDist) {
        boolean ret = false;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] pos = q.poll();
                for (int i = 0; i < 4; ++i) {
                    int y = pos[0] + dy[i];
                    int x = pos[1] + dx[i];
                    if (!inRange(y, x)) continue;
                    if (arr[y][x] == 0) {
                        arr[y][x] = pos[2];
                        q.add(new int[]{y, x, pos[2]});
                        ret = true;
                    }
                }
            }
            maxDist--;
            if(maxDist == 0) break;
        }
        return ret;
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < m;
    }
}
