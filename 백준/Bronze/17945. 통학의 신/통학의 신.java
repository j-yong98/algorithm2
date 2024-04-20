import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    /**
     * 통학의 신
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        double sqrt = Math.sqrt((b * b) - c);
        int ans1 = (int) (-b - sqrt);
        int ans2 = (int) (-b + sqrt);
        if (ans1 == ans2) {
            System.out.println(ans1);
        } else {
            System.out.println(ans1 + " " + ans2);
        }
        br.close();
    }
}