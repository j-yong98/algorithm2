import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 10;
        while (N > 1) {
            N >>= 1;
            ans++;
        }
        System.out.println(ans);
    }
}