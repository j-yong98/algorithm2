import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static String L, R;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = st.nextToken();
        R = st.nextToken();
        int ans = 0;
        if (L.length() == R.length()) {
            for (int i = 0; i < L.length(); i++) {
                char a = L.charAt(i);
                char b = R.charAt(i);
                if (a == b && a == '8')
                    ans++;
                else if (a != b)
                    break;
            }
        }
        System.out.println(ans);
    }
}