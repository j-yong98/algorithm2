import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[][] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        ans = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                ans[i][j] = line.charAt(j) - '0';
            }
        }
        int cnt = 0;
        for (int i = 0; i <= N - 3; i++) {
            for (int j = 0; j <= M - 3; j++) {
                if (arr[i][j] != ans[i][j]) {
                    reveres(i, j);
                    cnt++;
                }
            }
        }
        boolean flag = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] != ans[i][j]) {
                    flag = false;
                    break;
                }
            }
            if (!flag)
                break;
        }
        if (!flag)
            System.out.println(-1);
        else
            System.out.println(cnt);
    }

    private static void reveres(int y, int x) {
        for (int i = 0; i < 3; i++) {
            if (i + y >= N) break;
            for (int j = 0; j < 3; j++) {
                if (j + x >= M) break;
                arr[y + i][x + j] ^= 1;
            }
        }
    }
}