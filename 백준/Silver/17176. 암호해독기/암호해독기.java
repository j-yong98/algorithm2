import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int SIZE = 53;
    static int N;
    static int[] arr = new int[SIZE];
    static char[] ch;

    /**
     * 암호 해독기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int idx = Integer.parseInt(st.nextToken());
            arr[idx]++;
        }
        ch = br.readLine().toCharArray();
        boolean flag = true;
        for (int i = 0; i < N; i++) {
            int c = to(ch[i]);
            if (arr[c] < 1) {
                flag = false;
                break;
            } else {
                arr[c] -= 1;
            }
        }
        if (flag) {
            System.out.println("y");
        } else {
            System.out.println("n");
        }
        br.close();
    }

    private static int to(char ch) {
        if (Character.isUpperCase(ch)) {
            ch -= 64;
        } else if (Character.isLowerCase(ch)){
            ch -= 70;
        } else {
            ch -= 32;
        }
        return ch;
    }
}