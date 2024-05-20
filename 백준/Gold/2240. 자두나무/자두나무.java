import java.io.*;
import java.util.Arrays;

class Main {
    static int T, M;
    static int[] arr;
    static int[][][] dp = new int[3][1010][35];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        T = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        arr = new int[T + 1];
        for (int i = 1; i <= T; i++)
            arr[i] = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            for (int j = 1; j <= M + 1; j++) {
                if (arr[i] == 1) {
                    dp[1][i][j] = Math.max(dp[1][i - 1][j] + 1, dp[2][i - 1][j - 1] + 1);
                    dp[2][i][j] = Math.max(dp[1][i - 1][j - 1], dp[2][i - 1][j]);
                } else {
                    if (i == 1 && j == 1)
                        continue;
                    dp[2][i][j] = Math.max(dp[2][i - 1][j] + 1, dp[1][i - 1][j - 1] + 1);
                    dp[1][i][j] = Math.max(dp[1][i - 1][j], dp[2][i - 1][j - 1]);
                }
            }
        }
        bw.write(Math.max(Arrays.stream(dp[1]).flatMapToInt(Arrays::stream).max().getAsInt(), Arrays.stream(dp[2]).flatMapToInt(Arrays::stream).max().getAsInt()) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}