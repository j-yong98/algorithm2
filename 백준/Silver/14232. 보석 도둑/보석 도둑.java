import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    /**
     * 보석 도둑
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long K = Long.parseLong(br.readLine());
        List<Long> list = new ArrayList<>();
        for (long i = 2; i <= Math.sqrt(K); i++) {
            while (K % i == 0) {
                list.add(i);
                K /= i;
            }
        }
        if (K != 1) {
            list.add(K);
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        list.forEach(i -> sb.append(i).append(" "));
        System.out.println(sb);
        br.close();
    }
}