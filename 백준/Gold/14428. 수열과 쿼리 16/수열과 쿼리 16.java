import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        tree = new int[4 * N];
        Arrays.fill(tree, -1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        init(1, 0, N - 1);
        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                int idx = Integer.parseInt(st.nextToken()) - 1;
                int val = Integer.parseInt(st.nextToken());
                arr[idx] = val;
                updateQuery(1, 0, N - 1, idx);
            } else {
                int left = Integer.parseInt(st.nextToken()) - 1;
                int right = Integer.parseInt(st.nextToken()) - 1;
                int index = search(1, left, right, 0, N - 1);
                sb.append(index + 1).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }

    private static int updateQuery(int node, int left, int right, int idx) {
        if (idx < left || idx > right || left == right) return tree[node];

        int mid = (left + right) / 2;
        int a = updateQuery(node * 2, left, mid, idx);
        int b = updateQuery(node * 2 + 1, mid + 1, right, idx);
        return tree[node] = merge(a, b);
    }

    private static int search(int node, int start, int end, int left, int right) {
        if (left > end || right < start) return -1;

        if (tree[node] >= start && tree[node] <= end) return tree[node];

        int mid = (left + right) / 2;
        int a = search(node * 2, start, end, left, mid);
        int b = search(node * 2 + 1, start, end, mid + 1, right);
        if (a == -1 && b == -1)
            return -1;
        else if (a == -1 && b >= 0)
            return b;
        else if (a >= 0 && b == -1)
            return a;
        return merge(a, b);
    }

    private static int init(int node, int left, int right) {
        if (left == right)
            return tree[node] = left;

        int mid = (left + right) / 2;
        int a = init(node * 2, left, mid);
        int b = init(node * 2 + 1, mid + 1, right);
        return tree[node] = merge(a, b);
    }

    private static int merge(int a, int b) {
        if (arr[a] > arr[b])
            return b;
        else if (arr[a] == arr[b]) {
            if (a < b) return a;
            else return b;
        }
        return a;
    }
}
