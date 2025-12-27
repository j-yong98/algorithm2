import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static int N, M;
  static boolean[][] visited;
  static List<List<Node>> edges;
  static int ans;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    while (true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      if (N == 0 && M == 0) {
        break;
      }
      visited = new boolean[N][N];
      edges = new ArrayList<>();
      for (int i = 0; i < N; i++) {
        edges.add(new ArrayList<>());
      }
      ans = 0;
      for (int i = 0; i < M; i++) {
        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        edges.get(u).add(new Node(v));
        edges.get(v).add(new Node(u));
      }
      for (int i = 0; i < N; i++) {
        f(i, 0);
      }
      sb.append(ans).append("\n");
    }
    System.out.print(sb);
  }

  private static void f(int now, int s) {
    ans = Math.max(ans, s);
    for (int i = 0; i < edges.get(now).size(); i++) {
      Node next = edges.get(now).get(i);
      if (visited[now][next.v]) {
        continue;
      }
      visited[now][next.v] = true;
      visited[next.v][now] = true;
      f(next.v, s + 1);
      visited[now][next.v] = false;
      visited[next.v][now] = false;
    }
  }

  static class Node {

    int v;

    public Node(int v) {
      this.v = v;
    }
  }
}