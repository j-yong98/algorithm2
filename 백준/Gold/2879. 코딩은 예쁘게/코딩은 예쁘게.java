import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num - arr[i];
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == 0) {
                continue;
            }
            while (arr[i] != 0) {
                int min = Math.abs(arr[i]);
                int idx = i;
                for (int j = i + 1; j < N; j++) {
                    if (!isEqual(arr[i], arr[j]) || arr[j] == 0) {
                        break;
                    }
                    if (min > Math.abs(arr[j])) {
                        min = Math.abs(arr[j]);
                    }
                    idx = j;
                }

                for (int j = i; j <= idx; j++) {
                    arr[j] = arr[j] < 0 ? arr[j] + min : arr[j] - min;
                }
                cnt += min;
            }
        }
        System.out.println(cnt);
    }

    private static boolean isEqual(int a, int b) {
        return func(a) == func(b);
    }

    private static boolean func(int a) {
        return a > 0;
    }
}