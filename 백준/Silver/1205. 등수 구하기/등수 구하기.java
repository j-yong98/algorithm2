import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static int N, S, P;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        if (N > 0)
            st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int rank = 1;
        int dup = 0;
        Arrays.sort(arr);
        for (int i = N; i > 0; i--) {
            if (arr[i] > S) {
                rank++;
                dup = 0;
            } else if (arr[i] == S) {
                dup++;
            }
            else break;
        }
        if (rank + dup > P)
            System.out.println(-1);
        else
            System.out.println(rank);
    }
}