import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static int N;
    static Map<String, Integer> words = new HashMap<>();
    /**
     * Maximum Word Frequency
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            words.put(word, words.getOrDefault(word, 0) + 1);
        }
        List<String> w = new ArrayList<>(words.keySet());
        Collections.sort(w);
        int max = 0;
        String ans = "";
        for (String word : w) {
            int cnt = words.get(word);
            if (max <= cnt) {
                max = cnt;
                ans = word;
            }
        }
        System.out.println(ans + " " + max);
        br.close();
    }

}