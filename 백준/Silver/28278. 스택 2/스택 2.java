import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack s = new Stack();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int[] cmd = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            switch (cmd[0]) {
                case 1:
                    s.push(cmd[1]);
                    break;
                case 2:
                    sb.append(s.pop()).append("\n");
                    break;
                case 3:
                    sb.append(s.size()).append("\n");
                    break;
                case 4:
                    sb.append(s.isEmpty()).append("\n");
                    break;
                case 5:
                    sb.append(s.peek()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }

    static class Stack {
        final int MAX = 1_000_000;
        int[] s = new int[MAX + 1];
        int top = 0;

        void push(int data) {
            s[top++] = data;
        }

        int pop() {
            return isEmpty() == 0 ? s[--top] : -1;
        }

        int size() {
            return top;
        }

        int isEmpty() {
            return top == 0 ? 1 : 0;
        }

        int peek() {
            return isEmpty() == 0 ? s[top - 1] : -1;
        }
    }
}