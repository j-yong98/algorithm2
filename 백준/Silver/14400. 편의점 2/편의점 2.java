import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int MAX = 1_000_000;
    static int N;
    static int[] x;
    static int[] y;
    /**
     * 편의점 2
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        x = new int[N];
        y = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        Arrays.sort(x);
        Arrays.sort(y);
        int[] mid = new int[]{x[N / 2], y[N / 2]};

        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += getDist(mid, new int[]{x[i], y[i]});
        }
        System.out.println(sum);
    }

    private static int getDist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}