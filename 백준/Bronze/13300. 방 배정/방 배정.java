import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N, K;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    int[][] arr = new int[7][2];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      arr[y][s]++;
    }
    int ans = 0;
    for (int i = 1; i <= 6; i++) {
      for (int j = 0; j < 2; j++) {
        int n = arr[i][j];
        ans += n / K;
        if (n % K != 0) {
          ans++;
        }
      }
    }
    System.out.println(ans);
  }
}