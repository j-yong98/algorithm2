import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int N;
    static String[] str;

    /**
     * 학생 번호
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        str = new String[N];
        int len = 0;
        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
            len = str[i].length();
        }
        for (int k = 0; k < len; k++) { //자리수
            Set<String> set = new HashSet<>();
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                String sub = str[i].substring(len - k - 1);
                if (set.contains(sub)) {
                    break;
                }
                set.add(sub);
                cnt++;
            }
            if (cnt == N) {
                System.out.println(k + 1);
                break;
            }
        }
        br.close();
    }
}