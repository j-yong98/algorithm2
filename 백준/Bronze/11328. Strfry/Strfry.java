import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String a = st.nextToken();
      String b = st.nextToken();
      if (a.length() != b.length()) {
        sb.append("Impossible\n");
        continue;
      }
      int[] temp = new int[26];
      for (int j = 0; j < a.length(); j++) {
        int ch = a.charAt(j) - 'a';
        temp[ch]++;
      }
      boolean flag = true;
      for (int j = 0; j < b.length(); j++) {
        int ch = b.charAt(j) - 'a';
        if (temp[ch] == 0) {
          flag = false;
          break;
        }
        temp[ch]--;
      }
      if (flag) {
        sb.append("Possible\n");
      } else {
        sb.append("Impossible\n");
      }
    }
    System.out.print(sb);
  }
}