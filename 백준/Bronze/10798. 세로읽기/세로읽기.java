import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {


    /**
     * 세로 읽기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                String s = list.get(j);
                if (s.length() <= i) {
                    continue;
                }
                sb.append(list.get(j).charAt(i));
            }
        }
        System.out.println(sb);
        br.close();
    }
}