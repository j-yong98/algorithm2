import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /**
     * 누울 자리를 찾아라
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == '.') {
                    cnt++;
                } else {
                    if (cnt >= 2) ans += 1;
                    cnt = 0;
                }
            }
            if (cnt >= 2) ans += 1;
        }
        System.out.print(ans + " ");
        ans = 0;
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (arr[j][i] == '.') {
                    cnt++;
                } else {
                    if (cnt >= 2) ans += 1;
                    cnt = 0;
                }
            }
            if (cnt >= 2) ans += 1;
        }
        System.out.println(ans);
        br.close();
    }
}