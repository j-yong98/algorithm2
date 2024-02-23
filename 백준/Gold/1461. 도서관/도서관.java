import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int ans = 0;
    static int N, M;
    static List<Integer> negative = new ArrayList<>();
    static List<Integer> positive = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int pos = Integer.parseInt(st.nextToken());
            if (pos < 0) {
                negative.add(pos);
            } else {
                positive.add(pos);
            }
        }

        negative.sort((a, b) -> Integer.compare(Math.abs(a), Math.abs(b)));
        positive.sort((a, b) -> Integer.compare(Math.abs(a), Math.abs(b)));

        int l1 = 0;
        if (!negative.isEmpty()) {
            int r1 = negative.size() % M;
            int idx1 = getRemainDist(negative,  r1);
            l1 = getDist(negative, idx1);
        }

        int l2 = 0;
        if (!positive.isEmpty()) {
            int r2 = positive.size() % M;
            int idx2 = getRemainDist(positive, r2);
            l2 = getDist(positive, idx2);
        }

        ans -= Math.max(l1, l2);

        System.out.println(ans);
    }

    private static int getRemainDist(List<Integer> list, int remainder) {
        if (remainder != 0) {
            ans += Math.abs(list.get(remainder - 1)) * 2;
        }
        return remainder;
    }

    private static int getDist(List<Integer> list, int idx) {
        while (idx < list.size()) {
            idx += M;
            int dist = Math.abs(list.get(idx - 1));
            ans += dist * 2;
        }
        return Math.abs(list.get(idx - 1));
    }
}