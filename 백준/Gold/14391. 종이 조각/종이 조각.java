import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static String[] arr;
    static boolean[][] visited;
    static int ans = 0;
    /**
     * 문제이름
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        arr = new String[N];
        for (int i = 0; i < N; i++)
            arr[i] = br.readLine();
        dfs(0, 0, 0);
        System.out.println(ans);
        br.close();
    }

    private static void dfs(int y, int x, int sum) {
        if (x == M) {
            dfs(y + 1, 0, sum);
            return;
        }
        if (y == N) {
            ans = Math.max(ans, sum);
            return;
        }
        if (visited[y][x]) {
            dfs(y, x + 1, sum);
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (y + i > N || !checkRow(y, x, i)) break;
            int res = Integer.parseInt(getRow(y, x, i));
            for (int j = 0; j < i; j++)
                visited[y + j][x] = true;
            dfs(y, x + 1, sum + res);
            for (int j = 0; j < i; j++)
                visited[y + j][x] = false;
        }
        for (int i = 1; i <= M; i++) {
            if (x + i > M || !checkCol(y, x, i)) break;
            int res = Integer.parseInt(arr[y].substring(x, x + i));
            for (int j = 0; j < i; j++)
                visited[y][x + j] = true;
            dfs(y, x + 1, sum + res);
            for (int j = 0; j < i; j++)
                visited[y][x + j] = false;
        }
    }

    private static boolean checkRow(int y, int x, int len) {
        for (int i = 0; i < len; i++) {
            if (visited[y + i][x]) return false;
        }
        return true;
    }

    private static boolean checkCol(int y, int x, int len) {
        for (int i = 0; i < len; i++) {
            if (visited[y][x + i]) return false;
        }
        return true;
    }

    private static String getRow(int y, int x, int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++)
            sb.append(arr[y + i].charAt(x));
        return sb.toString();
    }
}