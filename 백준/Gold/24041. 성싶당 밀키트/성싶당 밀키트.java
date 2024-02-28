import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static long MAX = Integer.MAX_VALUE;
    static int N, G, K;
    static long[][] foods;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        foods = new long[N][];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int o = Integer.parseInt(st.nextToken());
            foods[i] = new long[]{s, l, o};
        }

        Arrays.sort(foods, (a, b) -> a[1] == b[1] ? -Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));

        long left = 0;
        long right = MAX;
        long ans = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        while (left <= right) {
            long mid = (left + right) >> 1;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                long res = getGerm(foods[i][0], foods[i][1], mid);
                if (foods[i][2] == 1) {
                    if (pq.size() < K) {
                        pq.add(res);
                    } else if (!pq.isEmpty() && pq.peek() < res){
                        pq.add(res);
                        pq.poll();
                    }
                }
                sum += res;
            }
            while (!pq.isEmpty()) {
                sum -= pq.poll();
            }
            if (sum <= G) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(ans);
        br.close();
    }

    private static long getGerm(long s, long l, long day) {
        return s * Math.max(1, day - l);
    }
}