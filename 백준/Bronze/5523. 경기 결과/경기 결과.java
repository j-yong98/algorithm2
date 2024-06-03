import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int a, b;

    /**
     * 경기 결과
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        a = b = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int val1 = Integer.parseInt(st.nextToken());
            int val2 = Integer.parseInt(st.nextToken());
            if (val1 == val2) continue;
            if (val1 > val2) a++;
            else b++;
        }
        System.out.println(a + " " + b);
        br.close();
    }
}