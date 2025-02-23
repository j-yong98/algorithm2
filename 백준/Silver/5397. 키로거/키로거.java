import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static int T;
    static Deque<Character> q1;
    static Deque<Character> q2;
    static String str;
    /**
     * 키로거
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            str = br.readLine();
            q1 = new ArrayDeque<>();
            q2 = new ArrayDeque<>();
            for (int i = 0; i < str.length(); i++) {
                char cmd = str.charAt(i);
                if (cmd == '>') {
                    if (!q2.isEmpty()) {
                        q1.addLast(q2.pollFirst());
                    }
                } else if (cmd == '<') {
                    if (!q1.isEmpty()) {
                        q2.addFirst(q1.pollLast());
                    }
                } else if (cmd == '-') {
                    if (!q1.isEmpty()) {
                        q1.pollLast();
                    }
                } else {
                    q1.addLast(cmd);
                }
            }
            while (!q1.isEmpty()) {
                sb.append(q1.pollFirst());
            }
            while (!q2.isEmpty()) {
                sb.append(q2.pollFirst());
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}