import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static final long MOD = 1_000_000_007;
  static int M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    M = Integer.parseInt(br.readLine());
    long ans = 0;
    for (int i = 0; i < M; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      long n = Long.parseLong(st.nextToken());
      long s = Long.parseLong(st.nextToken());
      // (b^x-2) % x
      long val = s * mul(n, MOD - 2) % MOD;
      ans = (ans + val) % MOD;
    }
    System.out.println(ans);
  }

  private static long mul(long a, long b) {
    if (b == 1) {
      return a;
    }
    if (b % 2 == 1) {
      return (a * mul(a, b - 1)) % MOD;
    }
    long val = mul(a, b / 2);
    return (val * val) % MOD;
  }

}