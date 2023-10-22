import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String vowel = "aeiouAEIOU";


    /**
     * 모음의 개수
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = br.readLine();
            if (line.equals("#")) break;
            char[] tmp = line.toCharArray();
            int cnt = 0;
            for (int i = 0; i < tmp.length; i++) {
                if (vowel.contains(String.valueOf(tmp[i]))) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

}