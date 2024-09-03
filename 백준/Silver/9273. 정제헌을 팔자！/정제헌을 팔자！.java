import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /**
     * 정제헌을 팔자!
     * 1/n = 1/x + 1/y = xy = n(x + y)
     * xy + nx + ny = 0
     * (x - n)(y - n) = n^2
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = br.readLine()) != null) {
            String[] cmd = line.split("/");
            int n = Integer.parseInt(cmd[1]);
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if ((n * n) % i == 0) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

}