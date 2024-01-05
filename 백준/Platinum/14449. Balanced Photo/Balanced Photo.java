import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;

    static Node[] arr;
    static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new int[4 * N];
        arr = new Node[N];
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());
            arr[i] = new Node(i, val);
        }
        Arrays.sort(arr, (a, b) -> a.val == b.val ? Integer.compare(a.idx, b.idx) : -Integer.compare(a.val, b.val));
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int a = query(1, 0, N - 1, 0, arr[i].idx - 1);
            int b = query(1, 0, N - 1, arr[i].idx + 1, N - 1);
            update(1, 0, N - 1, arr[i].idx);
            int min = Math.min(a, b);
            int max = Math.max(a, b);
            if (min * 2 < max) {
                ans += 1;
            }
        }
        System.out.println(ans);
    }

    private static int query(int node, int s, int e, int l, int r) {
        if (s > r || e < l) return 0;

        if (s >= l && r >= e) {
            return tree[node];
        }

        int mid = (s + e) >> 1;
        int a = query(node * 2, s, mid, l, r);
        int b = query(node * 2 + 1, mid + 1, e, l, r);
        return a + b;
    }

    private static void update(int node, int s, int e, int idx) {
        if (idx > e || idx < s) return;

        tree[node] += 1;
        if (s == e) return;

        int mid = (s + e) >> 1;
        update(node * 2, s, mid, idx);
        update(node * 2 + 1, mid + 1, e, idx);
    }

    static class Node {
        int idx;
        int val;

        public Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "idx=" + idx +
                    ", val=" + val +
                    '}';
        }
    }
}