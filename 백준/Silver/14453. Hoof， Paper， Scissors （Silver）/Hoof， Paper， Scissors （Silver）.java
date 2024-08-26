import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr  = new int[3][N + 1];
        for (int i = 1; i <= N; i++) {
            char str = br.readLine().charAt(0);
            for (int j = 0; j < 3; j++) {
                arr[j][i] = arr[j][i - 1];
            }
            if (str == 'H') {
                arr[0][i]++;
            } else if (str == 'P') {
                arr[1][i]++;
            } else {
                arr[2][i]++;
            }
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (k == j) {
                        continue;
                    }
                    max = Math.max(max, arr[j][i - 1] + (arr[k][N] - arr[k][i - 1]));
                }
            }
        }

        System.out.println(max);
    }
}