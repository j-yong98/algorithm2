import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M][];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()) - 1;
            int r = Integer.parseInt(st.nextToken()) - 1;
            arr[i] = new int[]{l, r};
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int l1 = o1[1] - o1[0];
                int l2 = o2[1] - o2[0];
                return Integer.compare(l1, l2);
            }
        });

        int k = arr[0][1] - arr[0][0] + 1;

        int[] x = new int[N];
        for (int i = 0; i < M; i++) {
            int l = arr[i][0];
            int r = arr[i][1];

            boolean[] checked = new boolean[k + 1];
            for (int j = l; j <= r; j++) {
                checked[x[j]] = true;
            }

            int val = 1;
            while (val < k && checked[val]) {
                val++;
            }

            for (int j = l; j <= r; j++) {
                if (x[j] == 0) {
                    x[j] = val;
                    checked[val] = true;
                }

                if (val == k) break;

                while (val < k && checked[val]) {
                    val++;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (x[i] == 0) {
                x[i] = k;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(x[i]).append(" ");
        }
        System.out.println(sb);
    }
}