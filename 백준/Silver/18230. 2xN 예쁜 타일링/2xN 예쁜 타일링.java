import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, A, B;
    static PriorityQueue<Integer> a = new PriorityQueue<>((a, b) -> -Integer.compare(a, b));
    static PriorityQueue<Integer> b = new PriorityQueue<>((a, b) -> -Integer.compare(a, b));
    /**
     * 2xN 예쁜 타일링
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            a.add(Integer.valueOf(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            b.add(Integer.valueOf(st.nextToken()));
        }

        int n = 0;
        int ans = 0;
        if (N % 2 == 1) {
            n += 1;
            ans += a.poll();
        }
        while (true) {
            if (n == N) {
                break;
            }

            if (a.size() < 2 || b.isEmpty()) {
                break;
            }

            n += 2;
            int val1 = a.poll();
            int val2 = a.poll();
            int val3 = b.poll();
            if (val1 + val2 > val3) {
                ans += val1 + val2;
                b.add(val3);
            } else {
                ans += val3;
                a.add(val1);
                a.add(val2);
            }
        }

        while (n + 2 <= N && a.size() >= 2) {
            n += 2;
            ans += a.poll();
            ans += a.poll();
        }

        while (n + 2 <= N && !b.isEmpty()) {
            n += 2;
            ans += b.poll();
        }

        System.out.println(ans);
        br.close();
    }
}