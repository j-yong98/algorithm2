import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String str;
    /**
     * 피카츄
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        str = str.replaceAll("pi|ka|chu", "");
        if (str.equals(""))
            System.out.println("YES");
        else
            System.out.println("NO");
        br.close();
    }
}