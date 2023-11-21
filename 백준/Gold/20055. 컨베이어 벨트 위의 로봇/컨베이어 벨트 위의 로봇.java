
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] arr;
    static boolean[] robots;
    static int cnt = 0;
    /**
     * 컨베이어 벨트 위의 로봇
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[2 * n];
        robots = new boolean[2 * n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        while (check()) {
            cnt++;
            rotate();
            moveRobot();
            raiseRobot();
        }
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
    private static boolean check() {
        int cnt = 0;
        for (int i = 0; i < 2 * n; i++) {
            if (arr[i] == 0) {
                cnt++;
                if (cnt == k)
                    return false;
            }
        }
        return true;
    }
    private static void raiseRobot() {
        if (arr[0] > 0 && !robots[0]) {
            arr[0]--;
            robots[0] = true;
        }
    }
    private static void rotate() {
        int tmp = arr[2 * n -1];
        for (int i = 2 * n - 1; i >= 1; i--)
            arr[i] = arr[i - 1];
        arr[0] = tmp;
        boolean bTmp = robots[2 * n - 1];
        for (int i = 2 * n - 1; i >= 1; i--)
            robots[i] = robots[i - 1];
        robots[0] = bTmp;
        if (robots[n - 1])
            robots[n - 1] = false;
    }
    private static void moveRobot() {
        for (int i = 2 * n - 1; i >= 0; i--) {
            if (!robots[i]) continue;
            int idx = (i + 1) % (2 * n);
            if (arr[idx] > 0 && !robots[idx]) {
                arr[idx]--;
                robots[idx] = true;
                robots[i] = false;
            }
        }
        if (robots[n - 1])
            robots[n - 1] = false;
    }
}
