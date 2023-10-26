import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static int N, K;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int[] diff = new int[N - 1];
        for (int i = 1; i < N; i++)
            diff[i - 1] = arr[i] - arr[i - 1];
        Arrays.sort(diff);
        int ans = 0;
        for (int i = 0; i < N - K; i++)
            ans += diff[i];
        System.out.println(ans);
    }
}