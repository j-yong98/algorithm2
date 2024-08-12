import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int T;
    static int N;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i <= 45; i++) {
            if (list.isEmpty()) {
                list.add(i);
            } else {
                list.add(list.get(list.size() - 1) + i);
            }
        }
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            boolean flag = false;
            N = Integer.parseInt(br.readLine());
            for (int i = 0; i < list.size(); i++) {
                int a = list.get(i);
                if (a > N) {
                    break;
                }
                for (int j = 0; j < list.size(); j++) {
                    int b = list.get(j);
                    if (a + b > N) {
                        break;
                    }
                    int c = N - (a + b);
                    if (list.contains(c)) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
            sb.append(flag ? 1 : 0).append("\n");
        }
        System.out.print(sb);
    }

}