import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static final int MAX = 30000;
    static int[] arr = new int[MAX + 1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            arr[i] = i;
        }
        for (int i = 1; i <= N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (findParent(i) != findParent(n)) {
                union(i, n);
            }
        }
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (arr[i] == i) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    private static int findParent(int a) {
        if (a == arr[a]) return a;
        return arr[a] = findParent(arr[a]);
    }

    private static void union(int a, int b) {
        int p1 = findParent(a);
        int p2 = findParent(b);
        if (p1 < p2) {
            arr[p2] = p1;
        } else {
            arr[p1] = p2;
        }
    }
}