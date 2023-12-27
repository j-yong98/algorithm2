import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[] a;
    static char[] b;
    static int[] arr = new int[26];
    /**
     * 애너그램 만들기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine().toCharArray();
        b = br.readLine().toCharArray();
        for (int i = 0; i < a.length; i++) {
            arr[a[i] - 'a'] += 1;
        }
        for (int i = 0; i < b.length; i++) {
            arr[b[i] - 'a'] -= 1;
        }
        int answer = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) answer += Math.abs(arr[i]);
        }
        System.out.println(answer);
        br.close();
    }
}