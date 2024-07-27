import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static Map<String, Integer> count = new HashMap<>();
    static List<String> strings = new ArrayList<>();
    /**
     * 영단어 암기는 괴로워
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() < M) {
                continue;
            }
            if (!count.containsKey(word)) {
                strings.add(word);
            }
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        Collections.sort(strings, (a, b) -> {
           int aCnt = count.get(a);
           int bCnt = count.get(b);
           if (aCnt == bCnt) {
               if (a.length() == b.length()) {
                   for (int i = 0; i < a.length(); i++) {
                       char ch1 = a.charAt(i);
                       char ch2 = b.charAt(i);
                       if (ch1 != ch2) {
                           return ch1 - ch2;
                       }
                   }
               }
               return -Integer.compare(a.length(), b.length());
           }
           return -Integer.compare(aCnt, bCnt);
        });
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            sb.append(string).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}