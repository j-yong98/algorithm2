import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            int len = str.length();
            if (len >= 6 && len <= 9) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}