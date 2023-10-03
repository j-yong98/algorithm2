import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 500_000;
    static int N;
    static Node[] arr;
    static int[] tree;
    static int[] path;
    /**
     * 전깃줄 - 2
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Node[N + 1];
        tree = new int[4 * MAX];
        path = new int[N + 1];
        tree[0] = -1;
        arr[0] = new Node(-1, -1);
        int max = 0;
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = new Node(a, b);
            max = Math.max(max, Math.max(a, b));
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a.val, b.val));
        int[] ans = new int[max + 1];
        for (int i = 1; i <= N; i++) {
            ans[arr[i].idx] = query(1, 1, MAX, 1, arr[i].idx) + 1;
            update(1, 1, MAX, arr[i].idx, ans[arr[i].idx]);
        }
        Stack<Integer> stack = new Stack<>();
        int LIS = tree[1];
        for (int i = max; i >= 1; i--) {
            if (ans[i] == 0) continue;
            if (LIS == ans[i])
                LIS = LIS - 1;
            else
                stack.add(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(N - tree[1]).append("\n");
        while (!stack.isEmpty())
            sb.append(stack.pop()).append("\n");
        System.out.println(sb);
        br.close();
    }

    private static int query(int node, int s, int e, int l, int r) {
        if (s > r || e < l) return 0;

        if (s >= l && r >= e) return tree[node];

        int mid = (s + e) >> 1;
        int a = query(node * 2, s, mid, l, r);
        int b = query(node * 2 + 1, mid + 1, e, l, r);
        return Math.max(a, b);
    }
    private static int update(int node, int s, int e, int idx, int val) {
        if (s > idx || e < idx) return tree[node];

        if (s == e) return tree[node] = val;

        int mid = (s + e) >> 1;
        int a = update(node * 2, s, mid, idx, val);
        int b = update(node * 2 + 1, mid + 1, e, idx, val);
        return tree[node] = Math.max(a, b);
    }

    static class Node {
        int idx;
        int val;

        public Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
}