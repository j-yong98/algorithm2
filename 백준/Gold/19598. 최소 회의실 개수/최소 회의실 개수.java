
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static List<int[]> time = new ArrayList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    /**
     * 최소 회의실 개수
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++)
            time.add(Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray());
        Collections.sort(time, (a, b)-> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        pq.add(time.get(0)[1]);
        for (int i = 1; i < N; i++) {
            if (!pq.isEmpty() && (pq.peek() <= time.get(i)[0]))
                pq.poll();
            pq.add(time.get(i)[1]);
        }
        System.out.println(pq.size());
        br.close();
    }
}
