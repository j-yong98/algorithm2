import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int X;
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            X = Integer.parseInt(line) * 10_000_000;
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(arr);
            boolean flag = false;
            int l = 0;
            int r = X;
            while (l <= r) {
                int mid = (l + r) >> 1;

                int[] solve = solve(mid);
                if (solve[0] + solve[1] == X) {
                    sb.append("yes ").append(solve[0]).append(" ").append(solve[1]).append("\n");
                    flag = true;
                    break;
                }
                if (solve[0] + solve[1] > X) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            if (!flag) {
                sb.append("danger\n");
            }
        }
        System.out.println(sb);
    }

    private static int[] solve(int value) {
        int l = 0;
        int r = N - 1;
        while (l < r) {
            int sum = arr[l] + arr[r];

            if (sum == value) return new int[]{arr[l], arr[r]};
            if (sum > value) {
                r--;
            } else {
                l++;
            }
        }
        return new int[2];
    }
}

