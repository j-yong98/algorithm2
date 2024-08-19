import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {
    static int Q;
    static Deque<Integer> q1 = new ArrayDeque<>();
    static Deque<Integer> q2 = new ArrayDeque<>();
    static int sum1 = 0, sum2 = 0;
    static int N = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Q = Integer.parseInt(br.readLine());
        for (int q = 0; q < Q; q++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            switch (cmd) {
                case 1:
                    int val = Integer.parseInt(st.nextToken());
                    q2.addLast(val);
                    sum2 += val;
                    break;
                case 2:
                    if (sum1 <= sum2) {
                        sb.append(sum1);
                    } else {
                        sb.append(sum2);
                        sum2 = sum1;
                        q2 = q1;
                    }
                    sum1 = 0;
                    q1 = new ArrayDeque<>();
                    sb.append("\n");
                    break;
            }
            re();
        }
        print(q1, sb);
        print(q2, sb);
        System.out.print(sb.toString().trim());
    }

    private static void re() {
        int N = q1.size() + q2.size();
        while (q1.size() < N / 2) {
            int val = q2.pollFirst();
            sum1 += val;
            sum2 -= val;
            q1.addLast(val);
        }
    }

    private static void print(Deque<Integer> q, StringBuilder sb) {
        int M = q.size();
        for (int i = 0; i < M; i++) {
            int val = q.pollFirst();
            q.addLast(val);
            sb.append(val).append(" ");
        }
    }
}