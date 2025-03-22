import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int a = Integer.parseInt(br.readLine());
            int l = 0;
            int r = N;

            while (l < r) {
                int mid = (l + r) >> 1;

                if (arr[mid] < a) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }

            if (r == N || (r < N && arr[r] != a)) {
                sb.append(-1);
            } else {
                sb.append(r);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}