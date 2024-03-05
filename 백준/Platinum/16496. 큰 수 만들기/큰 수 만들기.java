import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static String[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new String[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = st.nextToken();
        }
        Arrays.sort(arr, (a, b) -> compare(a, b));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]);
        }
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        System.out.println(sb);
        br.close();
    }

    private static int compare(String a, String b) {
        String tmp1 = a + b;
        String tmp2 = b + a;
        int len = tmp1.length();

        for (int i = 0; i < len; i++) {
            if (tmp1.charAt(i) != tmp2.charAt(i)) {
                return tmp2.charAt(i) - tmp1.charAt(i);
            }
        }

        return 0;
    }
}