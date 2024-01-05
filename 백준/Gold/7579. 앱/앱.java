import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 1_000_000_000;
    static int n, m;
    static int[] memory;
    static int[] costs;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        memory = new int[n + 1];
        costs = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
            sum += memory[i];
        }
        dp = new int[sum + 1];
        Arrays.fill(dp, MAX);
        dp[0] = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            costs[i] = Integer.parseInt(st.nextToken());
//        for (int i = 1; i <= n; i++)
//            dp[memory[i]] = costs[i];
        for (int i = 1; i <= n; i++) {
            for (int j = sum; j >= memory[i]; j--)
                dp[j] = Math.min(dp[j], dp[j - memory[i]] + costs[i]);
        }
        int ans = Arrays.stream(dp, m, sum + 1).min().getAsInt();
        System.out.println(ans);
    }
}