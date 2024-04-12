import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, S;
    static int[] tree;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N][];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            arr[i] = new int[]{i, val};
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));
        int num = 1;
        for (int i = 0; i < N;) {
            int e = i + 1;
            while (e < N && arr[i][1] == arr[e][1]) {
                e++;
            }
            while (i < e) {
                arr[i][1] = num;
                i++;
            }
            num++;
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(arr[i][1], max);
        }
        tree = new int[4 * max];
        long ans = 0;
        for (int i = 0; i < S; i++) {
            ans += query(1, 1, max, 1, arr[i][1] - 1);
            update(1, 1, max, arr[i][1], 1);
        }
        long tmp = ans;
        for (int i = S; i < N; i++) {
            int idx = i - S;
            tmp -= query(1, 1, max, arr[idx][1] + 1, max);
            update(1, 1, max, arr[idx][1], -1);

            tmp += query(1, 1, max, 1, arr[i][1] - 1);
            update(1, 1, max, arr[i][1], 1);

            ans = Math.max(ans, tmp);
        }
        System.out.println(ans);
    }

    private static int query(int root, int s, int e, int l, int r) {
        if (s > r || e < l) return 0;

        if (s >= l && r >= e) return tree[root];

        int mid = (s + e) >> 1;
        int a = query(root * 2, s, mid, l, r);
        int b = query(root * 2 + 1, mid + 1, e, l, r);
        return a + b;
    }

    private static void update(int root, int s, int e, int idx, int val) {
        if (s > idx || e < idx) return;

        tree[root] += val;
        if (s == e) {
            return;
        }

        int mid = (s + e) >> 1;
        update(root * 2, s, mid, idx, val);
        update(root * 2 + 1, mid + 1, e, idx, val);
    }

    private static Node[] change(int[] val) {
        int len = val.length;
        Node[] nodes = new Node[len];
        for (int i = 0; i < len; i++) {
            nodes[i] = new Node(i, val[i]);
        }
        return nodes;
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

