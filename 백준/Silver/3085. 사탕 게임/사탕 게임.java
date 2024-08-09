import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static final int[] dy = {0, 1};
    static final int[] dx = {1, 0};

    static int N;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int cnt1 = 1;
            int cnt2 = 1;
            for (int j = 1; j < N; j++) {
                if (arr[i][j] == arr[i][j - 1]) {
                    cnt1++;
                } else {
                    ans = Math.max(ans, cnt1);
                    cnt1 = 1;
                }
                if (arr[j][i] == arr[j - 1][i]) {
                    cnt2++;
                } else {
                    ans = Math.max(ans, cnt2);
                    cnt2 = 1;
                }
            }
            ans = Math.max(ans, Math.max(cnt1, cnt2));
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 2; k++) {
                    int y = i + dy[k];
                    int x = j + dx[k];
                    if (!inRange(y, x) || arr[i][j] == arr[y][x]) {
                        continue;
                    }
                    swap(i, j, y, x);
                    ans = Math.max(ans, check(i, j, y, x));
                    swap(i, j, y, x);
                }
            }
        }
        System.out.println(ans);
    }

    private static void printMap(int y, int x, int count) {
        System.out.println("count : " + count);
        System.out.println("pos : " + y + " " + x);
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println("-----------");
    }

    private static int check(int y1, int x1, int y2, int x2) {
        int max = 1;
        int cnt1 = 1;
        int cnt2 = 1;
        for (int i = 1; i < N; i++) {
            if (arr[y1][i] == arr[y1][i - 1]) {
                cnt1++;
                max = Math.max(max, cnt1);
            } else {
                cnt1 = 1;
            }
            if (arr[y2][i] == arr[y2][i - 1]) {
                cnt2++;
                max = Math.max(max, cnt2);
            } else {
                cnt2 = 1;
            }
        }
        cnt1 = 1;
        cnt2 = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i][x1] == arr[i - 1][x1]) {
                cnt1++;
                max = Math.max(max, cnt1);
            } else {
                cnt1 = 1;
            }
            if (arr[i][x2] == arr[i - 1][x2]) {
                cnt2++;
                max = Math.max(max, cnt2);
            } else {
                cnt2 = 1;
            }
        }
        return max;
    }

    private static void swap(int y1, int x1, int y2, int x2) {
        char temp = arr[y1][x1];
        arr[y1][x1] = arr[y2][x2];
        arr[y2][x2] = temp;
    }

    private static boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N;
    }
}