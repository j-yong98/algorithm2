import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int MAX = 100_000;
    static int N;
    static int[] arr;
    static boolean[] count = new boolean[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        long ans = 0;
        int r = 0;
        for (int i = 0; i < N; i++) {
            while (r < N && !count[arr[r]])
                count[arr[r++]] = true;
            ans += (r - i);
            count[arr[i]] = false;
        }
        System.out.println(ans);
    }
}