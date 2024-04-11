import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        ans = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int l = 0;
        int r = 0;
        for (int i = 0; i < N; i++) {
            l = Math.max(l, arr[i]);
            r += arr[i];
        }
        StringBuilder sb = new StringBuilder();
        while (l <= r) {
            int mid = (l + r) >> 1;

            if (getGroup(mid) > M) { //그룹의 개수가 많다 => 줄여야한다 => 최댓값을 올려야한다.
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        sb.append(l).append("\n");
        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (sum + arr[i] > l) {
                sb.append(cnt).append(" ");
                sum = 0;
                cnt = 0;
                M--;
            }
            sum += arr[i];
            cnt++;
            if (M == N - i) {
                for (int j = i; j < N; j++) {
                    sb.append(cnt).append(" ");
                    cnt = 1;
                }
                break;
            }
        }
        System.out.println(sb);
    }

    private static int getGroup(int mid) {
        int sum = 0, group = 0;
        for (int i = 0; i < N; i++) {
            if (sum + arr[i] > mid) {
                sum = 0;
                group++;
            }
            sum += arr[i];
        }
        if (sum != 0) {
            group++;
        }
        return group;
    }

}