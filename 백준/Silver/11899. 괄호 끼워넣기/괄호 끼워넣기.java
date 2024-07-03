import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    /**
     * 괄호 끼워넣기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!s.isEmpty() && c == ')' && s.peek() == '(') {
                s.pop();
            } else {
                s.push(c);
            }
        }
        System.out.println(s.size());
        br.close();
    }
}