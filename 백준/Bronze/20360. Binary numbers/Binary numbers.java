import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] binary = Integer.toBinaryString(n).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = binary.length - 1; i >= 0; i--) {
            if (binary[i] == '1') {
                sb.append(binary.length - i - 1).append(" ");
            }
        }
        System.out.println(sb);
    }
}