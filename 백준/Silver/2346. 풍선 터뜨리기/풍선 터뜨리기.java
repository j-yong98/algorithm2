import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    /**
     * 풍선 터뜨리기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<int[]> q = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            q.add(new int[]{i, val});
        }
        StringBuilder sb = new StringBuilder();
        int val = q.pollFirst()[1];
        sb.append(1).append(" ");
        while (!q.isEmpty()) {
            int[] arr;
            if (val > 0) {
                for (int i = 1; i < val; i++) {
                    q.add(q.poll());
                }
                arr = q.pollFirst();
                val = arr[1];
            } else {
                for (int i = 1; i < -val; i++) {
                    q.addFirst(q.pollLast());
                }
                arr = q.pollLast();
                val = arr[1];
            }
            sb.append(arr[0] + 1).append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}