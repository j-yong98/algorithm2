import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int R, C;
    static String[] strings;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        strings = new String[R];
        for (int i = 0; i < R; i++) {
            strings[i] = br.readLine();
        }
        int l = 0;
        int r = R; // 제거할 row 개수 = count
        while (l < r) {
            int mid = (l + r) >> 1;

            Set<String> set = new HashSet<>();
            boolean flag = false;
            for (int i = 0; i < C; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = mid; j < R; j++) {
                    sb.append(strings[j].charAt(i));
                }
                if (set.contains(sb.toString())) {
                    flag = true;
                    break;
                } else {
                    set.add(sb.toString());
                }
            }
            if (!flag) { // flag가 true면 제거할 row 수를 줄여봐야함
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        System.out.println(r - 1);
    }

}
