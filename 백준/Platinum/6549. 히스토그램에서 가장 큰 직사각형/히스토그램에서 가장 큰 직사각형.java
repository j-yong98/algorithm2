import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Stack<Node> s;
    static long ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if (N == 0) break;
            ans = 0;
            s = new Stack<>();
            for (int i = 0; i < N; i++) {
                long height = Long.parseLong(st.nextToken());
                Node now = new Node(height, 1);
                long pre = 0;
                while (!s.isEmpty()) {
                    Node top = s.peek();
                    if (top.height < height) {
                        s.push(now);
                        ans = Math.max(ans, pre * (now.cnt - 1));
                        break;
                    }
                    else {
                        Node pop = s.pop();
                        pre = pop.height;
                        now.cnt += pop.cnt;
                        ans = Math.max(ans, pre * (now.cnt - 1));
                    }
                }
                if (s.isEmpty())
                    s.push(now);
            }
            while (!s.isEmpty()) {
                Node pop = s.pop();
                if (!s.isEmpty())
                    s.peek().cnt += pop.cnt;
                ans = Math.max(ans, pop.cnt * pop.height);
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    static class Node {
        long height;
        int cnt;

        public Node(long height, int cnt) {
            this.height = height;
            this.cnt = cnt;
        }
    }
}