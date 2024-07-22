import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Stack<Integer> s = new Stack<>();
        int cur = 1;
        int idx = 0;
        while (idx < N) {
            while (!s.isEmpty()) {
                if (cur == s.peek()) {
                    s.pop();
                    cur++;
                } else {
                    break;
                }
            }
            if (arr[idx] == cur) {
                cur++;
            } else {
                s.push(arr[idx]);
            }
            idx++;
        }
        while (!s.isEmpty() && cur == s.peek()) {
            cur++;
            s.pop();
        }
        if (s.isEmpty()) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}