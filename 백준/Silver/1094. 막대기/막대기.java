import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MAX = 64;
    static int X;
    static int ans = 0;
    static int cnt = 0;
    /**
     * 막대기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        X = Integer.parseInt(br.readLine());
        div(MAX);
        System.out.println(cnt);
        br.close();
    }

    private static void div(int size) {
        if (size == 0) return;
        if (ans + size <= X) {
            ans += size;
            cnt += 1;
        }
        if (ans == X) return;
        int a = size >> 1;
        div(a);
    }
}