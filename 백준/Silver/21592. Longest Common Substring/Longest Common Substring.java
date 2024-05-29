import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        int ans = 0;
        for (int i = 0; i < arr[0].length(); i++) {
            for (int j = i; j < arr[0].length(); j++) {
                String str = arr[0].substring(i, j + 1);

                int cnt = 0;
                for (String s : arr) {
                    if (s.contains(str)) {
                        cnt++;
                    }
                }
                if (cnt == N) {
                    ans = Math.max(ans, str.length());
                }
            }
        }
        System.out.println(ans);
    }


}