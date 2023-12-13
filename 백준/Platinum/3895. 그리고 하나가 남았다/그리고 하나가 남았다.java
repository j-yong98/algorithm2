import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, M, K;
    static int[] tree;
    /**
     * 그리고 하나가 남았다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            boolean isFinish = true;
            for (int i = 0; i < 3; i++) {
                if (line[i] != 0) {
                    isFinish = false;
                    break;
                }
            }
            if (isFinish) {
                break;
            }

            N = line[0];
            K = line[1];
            M = line[2];
            tree = new int[4 * N + 1];
            init(1, 1, N);
            int k = M;
            for (int i = 0; i < N - 1; i++) {
                query(1, 1, N, k);
                if (i == N - 1) continue;
                k = (k + K - 1) % tree[1];
                if (k == 0) k = tree[1];
            }
            sb.append(query(1, 1, N, k)).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    private static int init(int node, int l, int r) {
        if (l == r) {
            return tree[node] = 1;
        }

        int mid = (l + r) >> 1;
        int a = init(node * 2, l, mid);
        int b = init(node * 2 + 1, mid + 1, r);
        return tree[node] = a + b;
    }

    private static int query(int node, int l, int r, int k) {
        if (l == r) {
            tree[node] -= 1;
            return l;
        }
        int res;
        int mid = (l + r) >> 1;
        if (tree[node * 2] >= k) res = query(node * 2, l, mid, k);
        else res = query(node * 2 + 1, mid + 1, r, k - tree[node * 2]);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
        return res;
    }
}