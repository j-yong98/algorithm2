import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 500_000;
    static int N;
    static int[] arr;
    /**
     * 아이템 배치하기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort(0, N - 1);
        int cnt = 0;
        int[] temp = new int[2 * N + 1];
        for (int i = 0; i < N; i++) {
            if (arr[i] == 0) continue;
            temp[i]++;
            temp[i + arr[i]]--;
        }
        for (int i = 1; i <= 2 * N; i++) {
            temp[i] += temp[i - 1];
        }
        for (int i = 0; i < N; i++) {
            if (temp[i] + temp[i + N] > 0) {
                cnt++;
            }
        }
        System.out.println(cnt);
        br.close();
    }

    private static void mergeSort(int l, int r) {
        if (l < r) {
            int mid = (l + r) >> 1;
            mergeSort(l, mid);
            mergeSort(mid + 1, r);
            merge(l, r, mid);
        }
    }

    private static void merge(int l, int r, int m) {
        int i = l;
        int j = m + 1;
        int n = r - l + 1;

        int idx = 0;
        int[] temp = new int[n];
        while (i <= m && j <= r) {
            if (arr[i] >= arr[j]) {
                temp[idx++] = arr[i++];
            } else {
                temp[idx++] = arr[j++];
            }
        }

        while (i <= m) {
            temp[idx++] = arr[i++];
        }
        while (j <= r) {
            temp[idx++] = arr[j++];
        }

        for (i = 0; i < n; i++) {
            arr[l + i] = temp[i];
        }
    }
}