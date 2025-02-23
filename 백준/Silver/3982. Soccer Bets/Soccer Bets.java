import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Set<String> winner;
    static Set<String> loser;
    /**
     * Soccer Bets
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            winner = new HashSet<>();
            loser = new HashSet<>();
            for (int j = 0; j < 16; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String t1 = st.nextToken();
                String t2 = st.nextToken();
                int g1 = Integer.parseInt(st.nextToken());
                int g2 = Integer.parseInt(st.nextToken());
                if (g1 > g2) {
                    if (!loser.contains(t1)) {
                        winner.add(t1);
                    }
                    winner.remove(t2);
                    loser.add(t2);
                } else {
                    if (!loser.contains(t2)) {
                        winner.add(t2);
                    }
                    winner.remove(t1);
                    loser.add(t1);
                }
            }
            for (String s : winner) {
                sb.append(s);
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}