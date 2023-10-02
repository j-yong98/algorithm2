import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    /**
     * Cubeditor
     */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = str.length();
        int max = 0;
        for (int k = 0; k < N; k++) {
            String sub = str.substring(k);
            max = Math.max(max, getTable(sub));
        }
        System.out.println(max);
        br.close();
    }

    private static int getTable(String str) {
        int N = str.length();

        int[] table = new int[N];
        int j = 0;
        for (int i = 1; i < N; i++) {
            while (j > 0 && str.charAt(i) != str.charAt(j))
                j = table[j - 1];
            if (str.charAt(i) == str.charAt(j))
                table[i] = ++j;
        }
        return Arrays.stream(table).max().getAsInt();
    }
}