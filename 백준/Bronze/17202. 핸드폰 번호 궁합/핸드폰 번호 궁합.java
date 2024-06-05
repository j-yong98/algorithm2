import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    /**
     * I am Groot
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            sb.append(a.charAt(i));
            sb.append(b.charAt(i));
        }

        while (sb.length() > 2) {
            int i;
            int len = sb.length();
            for (i = 1; i < len; i++) {
                int aa = sb.charAt(i) - '0';
                int bb = sb.charAt(i - 1) - '0';

                int r = (aa + bb) % 10;
                sb.deleteCharAt(i - 1);
                sb.insert(i - 1, String.valueOf(r));
            }
            sb.deleteCharAt(len - 1);
        }
        System.out.printf("%2s", sb);
        br.close();
    }
}