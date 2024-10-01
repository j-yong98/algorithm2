import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] answer;
    static int[] omr;
    static int[][] dp;
    static int ans = 0;

    /**
     * 재채점을 기다리는 중 어떻게 하면 문제를 많이 맞출까? 1. 아예 안옮긴다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        answer = new int[N];
        omr = new int[N + 1];
        dp = new int[N][K + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            omr[i] = Integer.parseInt(st.nextToken());
        }
        f(0, omr);
        System.out.println(ans);
        br.close();
    }

    private static void f(int k, int[] arr) {
        if (k > K) {
            return;
        }

        int cnt = getCorrect(arr);
        ans = Math.max(ans, cnt);

        for (int i = 0; i < N - 1; i++) {
            int[] pullArr = pull(i, arr);
            f(k + 1, pullArr);
            int[] pushArr = push(i, arr);
            f(k + 1, pushArr);
        }
    }

    private static int getCorrect(int[] arr) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == answer[i]) {
                cnt++;
            }
        }
        return cnt++;
    }

    private static int[] pull(int idx, int[] arr) {
        int[] temp = new int[N + 1];
        for (int i = 0; i < idx; i++) {
            temp[i] = arr[i];
        }
        for (int i = idx + 1; i < N; i++) {
            temp[i - 1] = arr[i];
        }
        return temp;
    }

    private static int[] push(int idx, int[] arr) {
        int[] temp = new int[N + 1];
        for (int i = 0; i < idx; i++) {
            temp[i] = arr[i];
        }
        for (int i = idx + 1; i < N; i++) {
            temp[i] = arr[i - 1];
        }
        return temp;
    }

}