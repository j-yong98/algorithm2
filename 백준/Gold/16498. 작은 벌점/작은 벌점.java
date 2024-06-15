import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] arr = new int[3];
    static int[][] cards = new int[3][];

    /**
     * 작은 별점
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            cards[i] = new int[arr[i]];
            for (int j = 0; j < arr[i]; j++) {
                cards[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 3; i++) {
            Arrays.sort(cards[i]);
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr[0]; i++) {
            int c1 = cards[0][i];
            int c2 = find(c1, cards[1]);
            int c3 = find(c1, cards[2]);

            ans = Math.min(ans, getDemerit(c1, c2, c3));

            c3 = find(c2, cards[2]);
            ans = Math.min(ans, getDemerit(c1, c2, c3));
        }
        System.out.println(ans);
        br.close();
    }

    private static int getDemerit(int c1, int c2, int c3) {
        int max = Math.max(c1, Math.max(c2, c3));
        int min = Math.min(c1, Math.min(c2, c3));
        return Math.abs(max - min);
    }

    private static int find(int key, int[] card) {
        int res = Integer.MAX_VALUE;

        int l = 0;
        int r = card.length - 1;
        while (l <= r) {
            int m = (l + r) >> 1;

            if (card[m] == key) {
                return card[m];
            }
            res = min(key, card[m], res);
            if (card[m] < key) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;
    }

    private static int min(int c1, int c2, int res) {
        return Math.abs(c1 - c2) < Math.abs(c1 - res) ? c2 : res;
    }
}