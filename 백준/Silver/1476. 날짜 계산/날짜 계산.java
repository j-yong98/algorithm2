import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int[] LIMIT = new int[]{15, 28, 19};
    static int[] arr = new int[3];
    static int[] tmp = new int[]{1, 1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken()) % LIMIT[i];
        }

        int cnt = 1;
        while (!isEqual()) {
            for (int i = 0; i < 3; i++) {
                tmp[i] = (tmp[i] + 1) % LIMIT[i];
            }
            cnt++;
        }
        System.out.println(cnt);
    }

    private static boolean isEqual() {
        for (int i = 0; i < 3; i++) {
            if (arr[i] != tmp[i]) {
                return false;
            }
        }
        return true;
    }

}