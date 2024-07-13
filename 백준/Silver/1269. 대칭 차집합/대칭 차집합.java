import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static Set<Integer> a = new HashSet<>();
    static Set<Integer> b = new HashSet<>();

    /**
     * 대칭 차집합
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a.add(Integer.valueOf(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            b.add(Integer.valueOf(st.nextToken()));
        }
        int cnt1 = 0;
        int cnt2 = 0;
        for (int e : a) {
            if (b.contains(e)) {
                cnt1++;
            }
        }
        for (int e : b) {
            if (a.contains(e)) {
                cnt2++;
            }
        }
        cnt1 = a.size() - cnt1;
        cnt2 = b.size() - cnt2;
        System.out.println(cnt1 + cnt2);
        br.close();
    }
}