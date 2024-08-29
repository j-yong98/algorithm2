import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N, M, A, B;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        arr = new int[M][];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            arr[i] = new int[]{l, r};
        }
        boolean[] visited = new boolean[N + 1];
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] now = q.pollFirst();

            if (now[0] == N) {
                System.out.println(now[1]);
                return;
            }

            if (isPossible(now[0] + A) && !visited[now[0] + A]) {
                visited[now[0] + A] = true;
                q.addLast(new int[]{now[0] + A, now[1] + 1});
            }
            if (isPossible(now[0] + B) && !visited[now[0] + B]) {
                visited[now[0] + B] = true;
                q.addLast(new int[]{now[0] + B, now[1] + 1});
            }
        }
        System.out.println(-1);
    }

    private static boolean isPossible(int val) {
        if (val > N) {
            return false;
        }

        for (int i = 0; i < M; i++) {
            if (arr[i][0] <= val && arr[i][1] >= val) {
                return false;
            }
        }

        return true;
    }
}