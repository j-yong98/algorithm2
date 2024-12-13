import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 100_000;
    static final int MAX_VAL = 100_000;
    static int N;
    static long D;
    static int[] monster = new int[MAX];
    static int[] equipment = new int[MAX];
    /**
     * 돌아온 똥게임
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        int mLen = 0;
        int eLen = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            if (a == 1) {
                monster[mLen++] = x;
            } else {
                equipment[eLen++] = x;
            }
        }

        Arrays.sort(monster, 0, mLen);
        Arrays.sort(equipment, 0, eLen);
        int cnt = eLen;
        int mIdx = 0;
        int eIdx = 0;
        while (mIdx < mLen) {
            while (eIdx < eLen && monster[mIdx] >= D) {
                D *= equipment[eIdx++];
            }
            if (monster[mIdx] < D) {
                D += monster[mIdx++];
                cnt++;
            } else {
                break;
            }
        }
        System.out.println(cnt);
        br.close();
    }
}