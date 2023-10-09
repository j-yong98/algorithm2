import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[][] arr;
    static int[] bag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][2];
        bag = new int[K];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[i][0] = m;
            arr[i][1] = v;
        }
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));
        for (int i = 0; i < K; i++)
            bag[i] = Integer.parseInt(br.readLine());
        Arrays.sort(bag);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        int j = 0;
        long ans = 0;
        for (int i = 0; i < K; i++) {
            while (j < N && arr[j][0] <= bag[i])
                pq.add(arr[j++][1]);
            if (!pq.isEmpty())
                ans += pq.poll();
        }
        System.out.println(ans);
    }
}