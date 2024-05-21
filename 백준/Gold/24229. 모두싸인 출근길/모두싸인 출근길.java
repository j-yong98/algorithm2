import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static List<int[]> pos = new ArrayList<>();
    static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            pq.add(new int[]{l, r});
        }

        int[] now = new int[2];
        while (!pq.isEmpty()) {
            int[] next = pq.poll();

            if (now[0] == 0 && now[1] == 0) {
                now[0] = next[0]; now[1] = next[1];
            } else {
                if (next[0] <= now[1]) {
                    now[1] = Math.max(now[1], next[1]);
                } else {
                    pos.add(new int[]{now[0], now[1]});
                    now[0] = next[0]; now[1] = next[1];
                }
            }
        }
        pos.add(now);

        int idx = 0;
        int dist = 0;
        for (int i = 0; i < pos.size(); i++) {
            int[] next = pos.get(i);
            if (dist >= next[0]) {
                idx = i;
                dist = Math.max(dist, next[1] + next[1] - next[0]);
            }
        }
        System.out.println(pos.get(idx)[1]);
    }

}