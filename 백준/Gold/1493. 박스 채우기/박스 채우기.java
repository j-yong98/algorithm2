import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int length, width, height;
    static int N;
    static int[] arr = new int[20];
    static long ans;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        length = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            arr[l] = q;
        }
        func(length, width, height);
        System.out.println(flag ? ans : -1);
        br.close();
    }

    public static void func(int x, int y, int z) {
        if (x == 0 || y == 0 || z == 0) {
            return;
        }
        flag = false;

        int len = 0;
        for (int i = 19; i >= 0; i--) {
            if (arr[i] == 0) continue;
            len = 1 << i;
            if (len <= x && len <= y && len <= z) {
                flag = true;
                arr[i]--;
                ans++;
                break;
            }
        }

        if (!flag) {
            return;
        }

        func(x - len, y, z);
        func(len, len, z - len);
        func(len, y - len, z);
    }
}