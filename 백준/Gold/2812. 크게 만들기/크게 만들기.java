import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        char[] line = br.readLine().toCharArray();

        Stack<Character> s = new Stack<>();
        int cnt = 0;
        int i;
        for (i = 0; i < N && cnt < K; i++) {
            char c = line[i];
            while (cnt < K && !s.isEmpty() && s.peek() < c) {
                cnt += 1;
                s.pop();
            }
            s.push(c);
        }
        while (i < N)
            s.push(line[i++]);
        while (cnt++ < K)
            s.pop();
        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty())
            sb.append(s.pop());
        System.out.println(sb.reverse());
    }

    private static int compare(String a, String b) {
        int len = a.length();
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i))
                return a.charAt(i) - b.charAt(i);
        }
        return 0;
    }

}