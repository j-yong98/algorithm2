import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] holes;
    static int[] arr;
    static int[] idx;
    /**
     * 멀티탭 스케줄링
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        holes = new int[N];
        arr = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        idx = new int[K + 1];
        for (int i = 0; i < K; i++)
            idx[arr[i]] = i;
        int ans = 0;
        for (int i = 0; i < K; i++) {
            if (contain(arr[i])) continue;
            int idx = getMaxIdx(i);
            if (holes[idx] != 0)
                ans++;
            holes[idx] = arr[i];
        }
        System.out.println(ans);
        br.close();
    }

    private static int getMaxIdx(int now) {
        for (int i = 0; i < N; i++) {
            int num = holes[i];
            if (num == 0) return i;
        }
        for (int i = 0; i < N; i++)
            if (idx[holes[i]] < now) return i;
        int[] tmp = new int[K + 1];
        for (int i = now + 1; i < K; i++) {
            if (tmp[arr[i]] != 0) continue;
            tmp[arr[i]] = i;
        }
        int index = -1;
        int max = -1;
        for (int i = 0; i < N; i++) {
            if (tmp[holes[i]] == 0) continue;
            if (max < tmp[holes[i]]) {
                max = tmp[holes[i]];
                index = i;
            }
        }
        return index;
    }

    private static boolean contain(int num) {
        for (int i = 0; i < N; i++) {
            if (holes[i] == num) return true;
        }
        return false;
    }
}