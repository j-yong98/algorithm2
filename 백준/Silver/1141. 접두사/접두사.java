import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    /**
     * 접두사
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] str = new String[N];
        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }
        Arrays.sort(str, Main::compare);
        int cnt = N;
        for (int i = 0; i < N; i++) {
            String a = str[i];
            for (int j = i + 1; j < N; j++) {
                String b = str[j];
                if (b.startsWith(a)) {
                    cnt--;
                    break;
                }
            }
        }
        System.out.println(cnt);
        br.close();
    }

    private static int compare(String a, String b) {
        if (a.length() < b.length()) {
            return -1;
        }
        if (a.length() > b.length()) {
            return 1;
        }
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                continue;
            }
            return b.charAt(i) - a.charAt(i);
        }
        return 0;
    }

}