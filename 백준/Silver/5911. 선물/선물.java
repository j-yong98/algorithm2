import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, B;
    static int[][] arr;

    /**
     * 선물
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        arr = new int[N][];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            arr[i] = new int[]{p, s};
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            // j한테 쿠폰 사용
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    pq.add(arr[j][0] / 2 + arr[j][1]);
                } else {
                    pq.add(arr[j][0] + arr[j][1]);
                }
            }

            int cnt = 0;
            int b = B;
            while (!pq.isEmpty() && b >= pq.peek()) {
                b -= pq.poll();
                cnt++;
            }

            ans = Math.max(ans, cnt);
        }
        System.out.println(ans);
        br.close();
    }

}