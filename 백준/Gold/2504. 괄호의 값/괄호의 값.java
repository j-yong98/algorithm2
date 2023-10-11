import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String str;
    static Stack<Node> s = new Stack<>();
    static Stack<Node> ans = new Stack<>();
    static int[] pair;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        int N = str.length();
        pair = new int[N];
        Arrays.fill(pair, -1);
        for (int i = 0; i < N; i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '[')
                s.push(new Node(c, i));
            else {
                if (s.isEmpty()) break;
                Node top = s.pop();
                if (Math.abs(top.c - c) > 2) continue;
                pair[i] = top.idx;
                pair[top.idx] = i;
            }
        }
        if (!s.isEmpty()) {
            System.out.println(0);
            return;
        }
        for (int i = 0; i < N; i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '[') continue;
            if (pair[i] == -1) {
                System.out.println(0);
                return;
            }
            int res = c == ')' ? 2 : 3;
            if (i - 1 == pair[i]) ans.push(new Node(res, i));
            else {
                int tmp = 0;
                while (!ans.isEmpty() && ans.peek().idx >= pair[i])
                    tmp += ans.pop().c;
                tmp = c == ')' ? tmp * 2 : tmp * 3;
                ans.push(new Node(tmp, i));
            }
        }
        int res = 0;
        while (!ans.isEmpty())
            res += ans.pop().c;
        System.out.println(res);
    }
    static class Node {
        int c;
        int idx;

        public Node(int c, int idx) {
            this.c = c;
            this.idx = idx;
        }
    }
}