import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    static int N, M;
    static Map<Character, Integer>[] maps;
    static String[] str;
    /**
     * DNA
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        str = new String[N];
        maps = new Map[M];
        for (int i = 0; i < N; i++)
            str[i] = br.readLine();

        for (int i = 0; i < M; i++)
            maps[i] = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                char c = str[i].charAt(j);
                maps[j].put(c, maps[j].getOrDefault(c, 0) + 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        int ans = 0;
        for (int i = 0; i < M; i++) {
            char c = 0;
            int max = 0;
            for (char ch : maps[i].keySet()) {
                int cnt = maps[i].get(ch);
                if (cnt > max) {
                    max = cnt;
                    c = ch;
                }
            }
            ans += N - max;
            sb.append(c);
        }
        sb.append("\n").append(ans);
        System.out.println(sb);
        br.close();
    }
}