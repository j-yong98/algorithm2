import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    static int N;
    static String exp;
    static Map<Character, Double> map = new HashMap<>();
    /**
     * 후위 표기식2
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        exp = br.readLine();
        for (int i = 0; i < N; i++) {
            Double val = Double.parseDouble(br.readLine());
            map.put((char) ('A' + i), val);
        }
        Stack<Double> s = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (ch == '+') {
                double val1 = s.pop();
                double val2 = s.pop();
                s.push(val1 + val2);
            } else if (ch == '-') {
                double val1 = s.pop();
                double val2 = s.pop();
                s.push(val2 - val1);
            } else if (ch == '/') {
                double val1 = s.pop();
                double val2 = s.pop();
                s.push(val2 / val1);
            } else if (ch == '*') {
                double val1 = s.pop();
                double val2 = s.pop();
                s.push(val2 * val1);
            } else {
                s.push(map.get(ch));
            }
        }
        System.out.printf("%.2f", s.pop());
        br.close();
    }
}