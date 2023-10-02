import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 60;
    static int N;
    static int[] hp;
    static int[][][] dp = new int[MAX + 1][MAX + 1][MAX + 1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        hp = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            hp[i] = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= MAX; i++) {
            for (int j = 0; j <= MAX; j++)
                Arrays.fill(dp[i][j], -1);
        }
        System.out.println(minTimes(hp[0], hp[1], hp[2]));
        br.close();
    }

    private static int minTimes(int x, int y, int z) {
        if (x == 0 && y == 0 && z == 0) return 0;

        if (dp[x][y][z] != -1) return dp[x][y][z];

        dp[x][y][z] = Integer.MAX_VALUE;

        dp[x][y][z] = Math.min(dp[x][y][z], minTimes(Math.max(x - 9, 0), Math.max(y - 3, 0), Math.max(z - 1, 0)) + 1);
        dp[x][y][z] = Math.min(dp[x][y][z], minTimes(Math.max(x - 9, 0), Math.max(y - 1, 0), Math.max(z - 3, 0)) + 1);
        dp[x][y][z] = Math.min(dp[x][y][z], minTimes(Math.max(x - 3, 0), Math.max(y - 9, 0), Math.max(z - 1, 0)) + 1);
        dp[x][y][z] = Math.min(dp[x][y][z], minTimes(Math.max(x - 1, 0), Math.max(y - 9, 0), Math.max(z - 3, 0)) + 1);
        dp[x][y][z] = Math.min(dp[x][y][z], minTimes(Math.max(x - 3, 0), Math.max(y - 1, 0), Math.max(z - 9, 0)) + 1);
        dp[x][y][z] = Math.min(dp[x][y][z], minTimes(Math.max(x - 1, 0), Math.max(y - 3, 0), Math.max(z - 9, 0)) + 1);
        return dp[x][y][z];
    }
}