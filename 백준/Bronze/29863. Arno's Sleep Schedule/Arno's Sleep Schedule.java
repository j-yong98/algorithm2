import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int sleep;
    static int wakeUp;
    /**
     * Arno's Sleep Schedule
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sleep = Integer.parseInt(br.readLine());
        wakeUp = Integer.parseInt(br.readLine());
        int ans = 0;
        while (sleep != wakeUp) {
            sleep = (sleep + 1) % 24;
            ans += 1;
        }
        System.out.println(ans);
        br.close();
    }

}