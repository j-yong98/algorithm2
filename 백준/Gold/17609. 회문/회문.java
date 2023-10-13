import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            sb.append(solve(line, 0, line.length() - 1, false)).append("\n");
        }
        System.out.println(sb);
    }

    private static int solve(String str, int left, int right, boolean delete) {
        while (left < right) {
            if (str.charAt(left) == str.charAt(right)) {
                left++; right--;
            } else if (!delete) {
                return (solve(str, left + 1, right, !delete) + solve(str, left, right - 1, !delete)) < 4 ? 1 : 2;
            } else
                return 2;
        }
        return 0;
    }
}