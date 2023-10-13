import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] weight;
    static int[] boxWeight;
    static boolean[] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        weight = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            weight[i] = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        boxWeight = new int[M];
        checked = new boolean[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            boxWeight[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(weight);
        Arrays.sort(boxWeight);
        int ans = 1;
        if (Arrays.stream(weight).max().getAsInt() < boxWeight[M - 1])
            ans = -1;
        else {
            int carry = 0;
            int[] idx = new int[N];
            for (int i = N - 1; i >= 0; i--) {
                for (int j = M - 1; j >= 0; j--) {
                    if (checked[j] || weight[i] < boxWeight[j]) continue;
                    carry++;
                    idx[i] = j;
                    checked[j] = true;
                    break;
                }
            }
            while (carry < M) {
                for (int i = N - 1; i >= 0; i--) {
                    if (idx[i] - 1 < 0) break;
                    for (int j = idx[i] - 1; j >= 0; j--) {
                        if (!checked[j]) {
                            carry += 1;
                            idx[i] = j;
                            checked[j] = true;
                            break;
                        } else {
                            if (i == 0) continue;
                            idx[i] = idx[i - 1];
                        }
                    }
                }
                ans += 1;
            }
        }
        System.out.println(ans);
    }
}