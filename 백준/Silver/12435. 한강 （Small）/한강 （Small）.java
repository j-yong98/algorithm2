import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final int MAX_CNT = 250;
    static final int MAX = 1_000_000;
    static int T;
    static int N, M;
    static List<List<Integer>> bros = new ArrayList<>();
    static List<List<Integer>> sisters = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init();
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int cnt = 0;
            int d = bros.get(N).size();
            // 자매관계(약수의 관계가 같다)이면서 그들의 남동생이 M 이상인 경우
            for (int cur : sisters.get(d)) {
                if (cur >= N) break;
                if (!bros.get(cur).isEmpty() && bros.get(cur).get(0) >= M) {
                    cnt++;
                }
            }
            sb.append("Case #").append(t + 1).append(": ").append(cnt).append("\n");
        }
        System.out.print(sb);
    }

    private static void init() {
        for (int i = 0; i <= MAX; i++) {
            bros.add(new ArrayList<>());
        }
        for (int i = 0; i < MAX_CNT; i++) {
            sisters.add(new ArrayList<>());
        }


        // 형제, 자매 구하기
        for (int i = 2; i <= MAX; i++) {
            int cnt = divisor(i);
            sisters.get(cnt).add(i);
        }

        for (List<Integer> s : sisters) {
            Collections.sort(s);
        }
    }

    private static int divisor(int val) {
        int cnt = 0;
        for (int i = 2; i <= Math.sqrt(val); i++) {
            if (val % i == 0) {
                bros.get(val).add(i);
                if (i * i == val) {
                    cnt += 1;
                } else {
                    bros.get(val).add(val / i);
                    cnt += 2;
                }
            }
        }
        return cnt;
    }
}