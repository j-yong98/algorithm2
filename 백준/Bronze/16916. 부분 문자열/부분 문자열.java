import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] table;
    static int N, M;
    /**
     * 부분 문자열
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();
        N = a.length;
        M = b.length;
        table = new int[M];
        int j = 0;
        for (int i = 1; i < M; i++) {
            while (j > 0 && b[i] != b[j])
                j = table[j - 1];
            if (b[i] == b[j]) {
                table[i] = ++j;
            }
        }

        boolean flag = false;
        j = 0;
        for (int i = 0; i < N; i++) {
            while (j > 0 && a[i] != b[j])
                j = table[j - 1];
            if (a[i] == b[j]) {
                if (j == M - 1) {
                    flag = true;
                    break;
                }
                j++;
            }
        }

        System.out.println(flag ? 1 : 0);
        br.close();
    }
}