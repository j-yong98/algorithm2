import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Problem[] problems = new Problem[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            problems[i] = new Problem(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(problems, (a, b) -> Integer.compare(a.num, b.num));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String p = problems[i].p;
            int d = problems[i].difficult - 1;
            sb.append(Character.toUpperCase(p.charAt(d)));
        }
        System.out.println(sb);
    }

    static class Problem {
        String p;
        Integer num;
        Integer difficult;

        public Problem(String p, Integer num, Integer difficult) {
            this.p = p;
            this.num = num;
            this.difficult = difficult;
        }
    }
}