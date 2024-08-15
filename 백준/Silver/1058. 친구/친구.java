import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static char[][] arr;
    static int ans = 0;
    static int[] checked;
    /**
     * 친구
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][];
        checked = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr[i][j] == 'Y') {
                    checked[i] += 1;
                    checked[j] += 1;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j || arr[i][j] == 'Y') {
                    continue;
                }

                for (int k = 0; k < N; k++) {
                    if (i == k || j == k) {
                        continue;
                    }

                    if (arr[i][k] == 'Y' && arr[j][k] == 'Y') {
                        checked[i] += 1;
                        break;
                    }
                }
            }
        }
        System.out.println(Arrays.stream(checked).max().getAsInt());
        br.close();
    }

}