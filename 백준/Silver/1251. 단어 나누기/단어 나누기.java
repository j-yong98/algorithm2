import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= str.length(); i++) {
            String a = substring(str, 0, i);
            for (int j = 1; j <= str.length(); j++) {
                if (i + j + 1 > str.length()) {
                    break;
                }
                String b = substring(str, i, j);
                String c = substring(str, i + j, str.length() - (i + j));
                if (b.isEmpty() || c.isEmpty()) {
                    continue;
                }
                String temp = reverse(a) + reverse(b) + reverse(c);
                list.add(temp);
            }
        }
        list.sort(String::compareTo);
        System.out.println(list.get(0));
    }

    private static String substring(String str, int startIndex, int length) {
        return str.substring(startIndex, startIndex + length);
    }

    private static String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

}