import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int sum = (K * (K + 1)) / 2;
        if (sum > N)
            System.out.println(-1);
        else if ((N - sum) % K == 0)
            System.out.println(K - 1);
        else
            System.out.println(K);
        br.close();
    }
}