import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int N;
    static int[] tree;
    static List<Node> arr;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        cnt = new int[N];
        tree = new int[4 * N + 1];
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());
            arr.add(new Node(i, val));
        }
        Collections.sort(arr, (a, b) -> a.val == b.val ? b.idx - a.idx : a.val - b.val);
        for (int i = 0; i < N; i++) {
            cnt[arr.get(i).idx] = query(0, arr.get(i).idx - 1);
            update(1, 0, N - 1, arr.get(i).idx);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++)
            sb.append(i - cnt[i] + 1).append("\n");
        System.out.print(sb);
        br.close();
    }

    private static int update(int node, int left, int right, int idx) {
        if (idx > right || idx < left) return tree[node];

        tree[node] += 1;
        if (left == right) return tree[node];

        int mid = (left + right) >> 1;
        return tree[node] = update(node * 2, left, mid, idx) + update(node * 2 + 1, mid + 1, right, idx);
    }

    private static int query(int s, int e) {
        return query(1, 0, N -  1, s, e);
    }

    private static int query(int node, int left, int right, int s, int e) {
        if (s > right || e < left) return 0;

        if (left >= s && e >= right) return tree[node];

        int mid = (left + right) >> 1;
        return query(node * 2, left, mid, s, e) + query(node * 2 + 1, mid + 1, right, s, e);
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
