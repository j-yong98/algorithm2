import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static long[] plays;
    static int[] visited;
    static int ans = Integer.MAX_VALUE;
    static int playCnt = 0;

    /**
     * 기타 콘서트
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        plays = new long[N];
        visited = new int[M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            char[] songs = st.nextToken().toCharArray();
            for (int j = 0; j < M; j++) {
                char song = songs[j];
                if (song == 'Y') {
                    plays[i] = (plays[i] | (1L << j));
                }
            }
        }
        f(0, 0, 0);
        System.out.println(ans == 0 ? -1 : ans);
        br.close();
    }

    private static void f(int l, int cnt, int p) {
        if (l == N) {
            if (p > playCnt) {
                playCnt = p;
                ans = cnt;
            } else if (playCnt == p) {
                ans = Math.min(ans, cnt);
            }
            return;
        }

        long play = plays[l];
        int pCnt = 0;
        for (int i = 0; i < M; i++) {
            boolean check = (play & (1L << i)) != 0;
            if (!check) {
                continue;
            }
            if (visited[i] == 0) pCnt++;
            visited[i]++;
        }
        f(l + 1, cnt + 1, p + pCnt);
        for (int i = 0; i < M; i++) {
            boolean check = (play & (1L << i)) != 0;
            if (check) {
                visited[i]--;
            }
        }
        f(l + 1, cnt, p);
    }
}