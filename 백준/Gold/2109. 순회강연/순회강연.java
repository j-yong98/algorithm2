import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Lecture[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Lecture[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            arr[i] = new Lecture(d, p);
        }
        Arrays.sort(arr, (a, b) -> a.day == b.day ? Integer.compare(a.pay, b.pay) : Integer.compare(a.day, b.day));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans = 0;
        for (int i = 0; i < N; i++) {
            pq.add(arr[i].pay);
            ans += arr[i].pay;
            if (pq.size() > arr[i].day)
                ans -= pq.poll();
        }
        System.out.println(ans);
    }
    static class Lecture {
        int day;
        int pay;

        public Lecture(int day, int pay) {
            this.day = day;
            this.pay = pay;
        }
    }
}