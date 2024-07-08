import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        StringBuilder sb = new StringBuilder();
        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            if (n == -1) {
                break;
            }
            List<Integer> list = new ArrayList<>();
            list.add(1);
            int sum = 1;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    list.add(i);
                    list.add(n / i);
                    sum += i;
                    sum += n / i;
                }
            }

            if (sum == n) {
                list.sort(Integer::compare);
                sb.append(n).append(" = ");
                for (int i = 0; i < list.size() - 1; i++) {
                    sb.append(list.get(i)).append(" + ");
                }
                sb.append(list.get(list.size() - 1));
            } else {
                sb.append(n).append(" is NOT perfect.");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}