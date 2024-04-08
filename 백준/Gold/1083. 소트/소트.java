import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            arr[i] = val;
        }
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int e = Math.min(N - 1, i + K);
            int maxIdx = max(i, e);
            swap(i, maxIdx);
            K -= maxIdx - i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }

    private static int max(int s, int e) {
        int idx = s;
        int max = arr[s];
        for (int i = s; i <= e; i++) {
            if (max < arr[i]) {
                idx = i;
                max = arr[i];
            }
        }
        return idx;
    }

    private static void swap(int i, int j) {
        int tmp = arr[j];
        for (int s = j; s > i; s--) {
            arr[s] = arr[s - 1];
        }
        arr[i] = tmp;
    }

}