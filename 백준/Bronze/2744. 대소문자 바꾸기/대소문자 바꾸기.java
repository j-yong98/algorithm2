import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] str = br.readLine().toCharArray();
        for (int i = 0; i < str.length; i++) {
            char c = str[i];
            if (c >= 'A' && c <= 'Z')
                sb.append((char)(c + 32));
            else if (c >= 'a' && c <= 'z')
                sb.append((char)(c - 32));
            else
                sb.append(c);
            
        }
        System.out.println(sb);
        br.close();
    }
}