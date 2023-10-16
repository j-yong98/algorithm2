import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static int N, K;
    static int[] arr;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        for (int i = 0; i < N - 1; i++)
            pq.add(arr[i + 1] - arr[i]);

        int cnt = 0;
        long ans = 0;
        while (!pq.isEmpty() && cnt < N - K) {
            cnt++;
            ans += pq.poll();
        }
        System.out.println(ans);
        br.close();
    }
    /**
     * N이 K라면 한 기지국당 한개를 커버할 수 있지만
     * 그게 아니라면 하나의 기지국은 N - K개의 기지국을 커버해야된다
     */
}