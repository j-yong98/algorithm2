import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    /**
     * 카드1
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            q.addLast(i);
        }
        StringBuilder sb = new StringBuilder();
        while (q.size() > 1) {
            int top = q.pollFirst();
            int sec = q.pollFirst();
            q.addLast(sec);
            sb.append(top).append(" ");
        }
        sb.append(q.poll());
        System.out.println(sb);
        br.close();
    }
}