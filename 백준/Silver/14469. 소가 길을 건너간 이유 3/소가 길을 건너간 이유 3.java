import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
    /**
     * 소가 길을 건너간 이유 3
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq.add(new int[]{a, b});
        }
        int time = 0;
        while (!pq.isEmpty()) {
            if (pq.peek()[0] > time) {
                time++;
                continue;
            }
            int[] now = pq.poll();
            for (int i = 0; i < now[1]; i++)
                time++;
        }
        System.out.println(time);
        br.close();
    }
}