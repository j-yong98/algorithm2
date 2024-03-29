import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static Node[] arr;
    static int[] copy;
    static int[] tree;
    static int[] cnt;
    static int max = 0;
    static int idx = 0;

    /**
     * 가장 긴 증가하는 부분 수열 5
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new Node[N];
        copy = new int[N];
        tree = new int[4 * N + 1];
        cnt = new int[N];
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            arr[i] = new Node(val, i);
            copy[i] = val;
        }
        Arrays.sort(arr, (a, b) -> a.val == b.val ? b.idx - a.idx : a.val - b.val);
        for (int i = 0; i < N; i++) {
            cnt[arr[i].idx] = query(0, arr[i].idx) + 1;
            update(1, 0, N - 1, arr[i].idx);
            if (max < cnt[arr[i].idx]) {
                max = cnt[arr[i].idx];
                idx = arr[i].idx;
            }
        }

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = idx; i >= 0; i--) {
            if (max != cnt[i]) continue;
            max -= 1;
            q.add(copy[i]);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(q.size()).append("\n");
        while (!q.isEmpty())
            sb.append(q.pollLast()).append(" ");
        System.out.println(sb);
        br.close();
    }

    private static int update(int node, int left, int right, int idx) {
        if (idx < left || idx > right) return tree[node];

        if (left == right) return tree[node] = cnt[left];

        int mid = (left + right) / 2;
        int a = update(node * 2, left, mid, idx);
        int b = update(node * 2 + 1, mid + 1, right, idx);
        return tree[node] = merge(a, b);
    }

    private static int query(int s, int e) {
        return query(1, 0, N - 1, s, e);
    }

    private static int query(int node, int left, int right, int s, int e) {
        if (left > e || right < s) return 0;

        if (left >= s && e >= right) return tree[node];

        int mid = (left + right) / 2;
        int a = query(node * 2, left, mid, s, e);
        int b = query(node * 2 + 1, mid + 1, right, s, e);
        return merge(a, b);
    }

    private static int merge(int a, int b) {
        return Math.max(a, b);
    }

    static class Node {
        int val;
        int idx;

        public Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
}
