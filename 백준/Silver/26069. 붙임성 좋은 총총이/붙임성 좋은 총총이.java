import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        set.add("ChongChong");
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] strs = br.readLine().split(" ");
            if (set.contains(strs[0]) || set.contains(strs[1])) {
                set.add(strs[0]);
                set.add(strs[1]);
            }
        }
        System.out.println(set.size());
    }
}