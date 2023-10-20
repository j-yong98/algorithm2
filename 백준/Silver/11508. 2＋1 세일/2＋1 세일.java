import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = N - 1; i >= 0; i--)
            q.addLast(arr[i]);
        long sum = 0;
        for (int i = 0; !q.isEmpty(); i++) {
            int tmp = q.pollFirst();
            if (i % 3 == 2) continue;
            sum += tmp;
        }
        System.out.println(sum);
        br.close();
    }
}