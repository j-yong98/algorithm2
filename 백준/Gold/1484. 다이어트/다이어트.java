import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int G;

    /**
     * 다이어트
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int l = 1;
        int r = 2;

        while (r <= 100_000) {
            int g = r * r - l * l;

            if (g == G) {
                sb.append(r).append("\n");
            }
            if (g > G) {
                l++;
            } else {
                r++;
            }
        }
        if (sb.length() == 0) {
            System.out.println(-1);
        } else {
            System.out.print(sb);
        }
        
        br.close();
    }
}