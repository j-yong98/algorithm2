import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[m];
        for (int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (line[j] == 'O') {
                    arr[j] = true;
                }
            }
        }
        int idx = -1;
        for (int i = 0; i < m; i++) {
            if (!arr[i]) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            System.out.println("ESCAPE FAILED");
        } else {
            System.out.println((idx + 1));
        }
    }
}

