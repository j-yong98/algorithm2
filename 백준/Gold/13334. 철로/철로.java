import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static int d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[i][0] = Math.min(s, e);
            arr[i][1] = Math.max(s, e);
        }
        d = Integer.parseInt(br.readLine());
        Arrays.sort(arr, (a, b) -> a[1] == b[1] ? Integer.compare(b[0], a[0]) : Integer.compare(a[1], b[1]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (Math.abs(arr[i][0] - arr[i][1]) > d) continue;
            while (!pq.isEmpty() && Math.abs(pq.peek()[0] - arr[i][1]) > d) {
                ans = Math.max(ans, pq.size());
                pq.poll();
            }
            pq.add(arr[i]);
        }
        ans = Math.max(ans, pq.size());
        System.out.println(ans);
    }
}