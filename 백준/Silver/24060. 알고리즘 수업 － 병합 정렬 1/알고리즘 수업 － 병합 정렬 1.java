import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] arr;
    static int count = 0;
    static int num = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort(0, N - 1);
        System.out.println(num);
    }

    private static void mergeSort(int l, int r) {
        if (l < r) {
            int m = (l + r) >> 1;
            mergeSort(l, m);
            mergeSort(m + 1, r);
            merge(l, m, r);
        }
    }

    private static void merge(int l, int m, int r) {
        int i = l;
        int j = m + 1;

        int[] temp = new int[r - l + 1];
        int idx = 0;
        while (i <= m && j <= r) {
            if (arr[i] <= arr[j]) {
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

        i = l;
        idx = 0;
        while (i <= r) {
            count++;
            if (count == K) {
                num = temp[idx];
            }
            arr[i++] = temp[idx++];
        }
    }
}