import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static String[] str = new String[3];
    static Map<String, Integer> value = new HashMap<>();
    static Map<String, Integer> multiple = new HashMap<>();
    /**
     * 저항
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init();
        for (int i = 0; i < 3; i++)
            str[i] = br.readLine();
        StringBuilder ans = new StringBuilder();
        ans.append(value.get(str[0])).append(value.get(str[1]));
        long tmp = Long.parseLong(ans.toString());
        tmp *= multiple.get(str[2]);
        System.out.println(tmp);
        br.close();
    }

    private static void init() {
        String[] colors = new String[]{"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
        for (int i = 0; i < colors.length; i++) {
            value.put(colors[i], i);
        }
        for (int i = 0; i < colors.length; i++) {
            multiple.put(colors[i], (int) Math.pow(10, i));
        }
    }
}