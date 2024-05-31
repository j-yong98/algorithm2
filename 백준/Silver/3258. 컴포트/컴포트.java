import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, Z, M;
    static boolean[] arr;

    /**
     * 컴포트
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Z = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int pos = Integer.parseInt(st.nextToken()) % N;
            arr[pos] = true;
        }
        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i <= Z; i++) {
            boolean flag = false;
            Arrays.fill(visited, false);
            int stand = 1;
            while (!visited[stand] && !arr[stand] && stand != Z) {
                visited[stand] = true;
                stand += i;
                if (stand > N) {
                    stand -= N;
                }
                if (stand == Z) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                System.out.println(i);
                break;
            }
        }
        br.close();
    }
}