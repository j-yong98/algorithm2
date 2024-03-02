import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int K;
    /**
     * 파일 합치기 3
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            K = Integer.parseInt(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int k = 0; k < K; k++) {
                pq.add(Long.valueOf(st.nextToken()));
            }
            long ans = 0;
            while (pq.size() > 1) {
                Long a = pq.poll();
                Long b = pq.poll();
                long sum = a + b;
                pq.add(sum);
                ans += sum;
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}