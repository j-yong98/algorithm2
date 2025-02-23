import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static Deque<Integer> q = new ArrayDeque<>();

    /**
     * 회전하는 큐
     * 1 2 3 4 5 6 7 8 9 10
     * 2 3 4 5 6 7 8 9 10 1 -> 1
     * 3 4 5 6 7 8 9 10 1
     * 9 10 1 3 4 5 6 7 8 -> 3
     * 5 6 7 8 9 10 1 3 4 -> 4
     * 8
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            q.addLast(i);
        }
        int ans = 0;
        for (int i = 0; i < M; i++) {
            int cur = arr[i];
            Deque<Integer> exp1 = new ArrayDeque<>();
            Deque<Integer> exp2 = new ArrayDeque<>();
            while (!q.isEmpty()) {
                int now = q.pollFirst();
                exp1.addLast(now);
                exp2.addLast(now);
            }
            int cnt1 = 0;
            while (!exp1.isEmpty()) {
                int now = exp1.pollFirst();
                if (now == cur) {
                    break;
                }
                exp1.addLast(now);
                cnt1++;
            }
            int cnt2 = 0;
            while (!exp2.isEmpty()) {
                if (exp2.peekFirst() == cur) {
                    break;
                }
                cnt2++;
                exp2.addFirst(exp2.pollLast());
            }
            exp2.pollFirst();
            if (cnt1 <= cnt2) {
                move(exp1, q);
                ans += cnt1;
            } else {
                move(exp2, q);
                ans += cnt2;
            }
        }
        System.out.println(ans);
        br.close();
    }

    private static void move(Deque<Integer> src, Deque<Integer> dst) {
        while (!src.isEmpty()) {
            dst.addLast(src.pollFirst());
        }
    }
}