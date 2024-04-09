import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 1_000_000;
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[MAX + 10];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(st.nextToken());
            if (arr[h + 1] > 0) {
                arr[h + 1]--;
            } else {
                ans++;
            }
            arr[h]++;
        }
        System.out.println(ans);
    }

}