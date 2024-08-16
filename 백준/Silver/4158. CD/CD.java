import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] a, b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) {
                break;
            }
            a = new int[N];
            b = new int[M];
            for (int i = 0; i < N; i++) {
                a[i] = Integer.parseInt(br.readLine());
            }
            for (int i = 0; i < M; i++) {
                b[i] = Integer.parseInt(br.readLine());
            }

            int ans = 0;
            int j = 0;
            for (int i = 0; i < N; i++) {
                while (j < M && a[i] > b[j]) {
                    j++;
                }
                if (a[i] == b[j]) {
                    ans++;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

}