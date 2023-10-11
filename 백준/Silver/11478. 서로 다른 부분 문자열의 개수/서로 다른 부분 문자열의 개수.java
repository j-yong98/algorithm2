import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String str;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        int N = str.length();
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                String sub = str.substring(i, j + 1);
                set.add(sub);
            }
        }
        System.out.println(set.size());
    }
}