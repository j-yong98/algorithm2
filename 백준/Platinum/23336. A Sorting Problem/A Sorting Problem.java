import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        tree = new long[N * 4 + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        System.out.println(countSwap(1, 0, N - 1))  ;
    }

    private static long countSwap(int node, int left, int right) {
        if (left == right) return tree[node] = 0;

        int mid = (left + right) / 2;
        long a = countSwap(node * 2, left, mid);
        long b = countSwap(node * 2 + 1, mid + 1, right);
        long cnt = swap(left, mid, right);
        return tree[node] = merge(a, b) + cnt;
    }

    private static long swap(int left, int mid, int right) {
        long res = 0;
        int l = left;
        int r = mid + 1;
        int[] tmp = new int[right - left + 1];
        int idx = 0;
        while (l <= mid && r <= right) {
            if (arr[l] > arr[r]) {
                res += mid - l + 1;
                tmp[idx++] = arr[r++];
            }
            else
                tmp[idx++] = arr[l++];
        }

        while (l <= mid)
            tmp[idx++] = arr[l++];

        while (r <= right)
            tmp[idx++] = arr[r++];

        for (int i = 0; i < tmp.length; i++)
            arr[left + i] = tmp[i];
        return res;
    }

    private static long merge(long a, long b) {
        return a + b;
    }
}
