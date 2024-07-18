import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    /**
     * 가로수
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int[] dist = new int[n - 1];
        for (int i = 1; i < n; i++) {
            dist[i - 1] = arr[i] - arr[i - 1];
        }

        int g = dist[0];
        for (int i = 1; i < n - 1; i++) {
            g = gcd(g, dist[i]);
        }

        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += (dist[i] / g) - 1;
        }
        System.out.println(sum);
        br.close();
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}