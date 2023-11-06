import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static int N;
    static int[] arr;
    static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        tree = new int[4 * N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            update(1, 1, N, i);
        }
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int cnt = Integer.parseInt(st.nextToken());
            int idx = query(1, 1, N, cnt);
            sb.append(idx).append(" ");
        }
        System.out.println(sb);
    }

    private static void update(int node, int s, int e, int idx) {
        if (s > idx || e < idx) return;

        if (s == e) {
            tree[node] = arr[idx];
            return;
        }

        int mid = (s + e) >> 1;
        update(node * 2, s, mid, idx);
        update(node * 2 + 1, mid + 1, e, idx);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    private static int query(int node, int s, int e, int k) {
        if (s == e) {
            tree[node] = 0;
            return s;
        }

        int tmp;

        int mid = (s + e) >> 1;
        if (tree[node * 2] >= k) tmp = query(node * 2, s, mid, k);
        else tmp = query(node * 2 + 1, mid + 1, e, k - tree[node * 2]);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
        return tmp;
    }
}