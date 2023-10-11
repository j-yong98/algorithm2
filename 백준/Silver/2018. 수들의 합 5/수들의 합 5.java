import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int l = 1;
        int r = 1;
        int sum = 1;
        long ans = 0;
        while (l <= r) {
            if (sum == N) {
                ans++;
                sum -= l++;
            } else if (sum < N)
                sum += ++r;
            else
                sum -= l++;
        }
        System.out.println(ans);
    }
}