import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String S;
    static StringBuilder T;

    /**
     * A와 B
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = new StringBuilder(br.readLine());
        int N = S.length();
        int M = T.length();
        
        while (N < M) {
            char c = T.charAt(M - 1);

            T.deleteCharAt(M - 1);
            if (c == 'B')
                T.reverse();

            M--;
        }
        
        if (S.equals(T.toString()))
            System.out.println(1);
        else
            System.out.println(0);
        br.close();
    }
}