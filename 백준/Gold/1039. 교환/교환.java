import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 1_000_000;
    static int N, M;
    static int K;
    static Set<Node> set = new HashSet<>();
    static int ans;
    /**
     * 교환
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = String.valueOf(N).length();

        Deque<Node> q = new ArrayDeque<>();
        q.add(new Node(N, 0));
        set.add(q.peekFirst());

        ans = 0;
        while (!q.isEmpty()) {
            Node now = q.pollFirst();

            if (now.k == K) {
                ans = Math.max(ans, now.num);
                continue;
            }

            String n = String.valueOf(now.num);
            for (int i = 0; i < M; i++) {
                for (int j = i + 1; j < M; j++) {
                    Node next = new Node(swap(n, i, j), now.k + 1);
                    if (set.contains(next) || length(next.num) != M) continue;
                    set.add(next);
                    q.add(next);
                }
            }
        }
        System.out.println(ans == 0 ? -1 : ans);
        br.close();
    }

    private static int length(int num) {
        int len = 0;
        while (num > 0) {
            len++;
            num /= 10;
        }
        return len;
    }

    private static int swap(String num, int i, int j) {
        char[] chars = num.toCharArray();
        chars[i] ^= chars[j];
        chars[j] ^= chars[i];
        chars[i] ^= chars[j];
        return Integer.parseInt(String.valueOf(chars));
    }

    static class Node {
        int num;
        int k;

        public Node(int num, int k) {
            this.num = num;
            this.k = k;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node) o;
            return num == node.num && k == node.k;
        }

        @Override
        public int hashCode() {
            return Objects.hash(num, k);
        }
    }
}