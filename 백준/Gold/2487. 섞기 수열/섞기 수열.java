import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited;
    /**
     * 섞기 수열
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        visited = new boolean[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long ans = 1;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                int j = i;
                int cnt = 0;
                while (!visited[j]) {
                    visited[j] = true;
                    j = arr[j];
                    cnt++;
                }
                ans = ans * cnt / gcd(ans, cnt);
            }
        }
        System.out.println(ans);
        br.close();
    }

    private static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}