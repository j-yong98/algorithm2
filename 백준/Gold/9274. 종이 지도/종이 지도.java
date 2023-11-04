import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final char BLANK = '.';
    static final char AREA = 'X';
    static final char FREE_ROW = '1';
    static final char FREE_PAGE = '0';
    static int N, M, R, C;
    static char[][] arr;

    /**
     * 종이 지도
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (str == null) {
                break;
            }
            StringTokenizer st = new StringTokenizer(str);
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            arr = new char[N + R][M + C];
            for (int i = 0; i < N; i++) {
                char[] line = br.readLine().toCharArray();
                for (int j = 0; j < M; j++) {
                    arr[i][j] = line[j];
                }
            }
            int[][] left = new int[N + R][M + C];
            for (int i = 0; i < N + R; i++) {
                int curCnt = 0;
                for (int j = 0; j < M + C; j++) {
                    if (i < N && j < M && arr[i][j] == AREA) {
                        curCnt++;
                    }
                    if (i < N && j - C >= 0 && arr[i][j - C] == AREA) {
                        curCnt--;
                    }
                    left[i][j] = curCnt;
                }
            }
            int[][] tile = new int[N + R][M + C];
            for (int j = 0; j < M + C; j++) {
                int curCnt = 0;
                for (int i = 0; i < N + R; i++) {
                    curCnt += left[i][j];
                    if (i - R >= 0)
                        curCnt -= left[i - R][j];
                    tile[i][j] = curCnt;
                }
            }
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    ans = Math.min(ans, count(tile, i, j));
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static void printArr(int[][] src) {
        for (int i = 0; i < src.length; i++) {
            for (int j = 0; j < src[i].length; j++) {
                System.out.print(src[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int count(int[][] tile, int y, int x) {
        int cnt = 0;
        for (int i = y; i < N + R; i+= R) {
            for (int j = x; j < M + C; j += C) {
                if (tile[i][j] > 0)
                    cnt++;
            }
        }
        return cnt;
    }
}