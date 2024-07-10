import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int N;
    static int[] level;
    static int[] parent;
    static int A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            parent = new int[N + 1];
            for (int i = 0; i < N - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                parent[b] = a;
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            sb.append(getCloset()).append("\n");
        }
        System.out.print(sb);
    }

    private static int getCloset() {
        boolean[] visited = new boolean[N + 1];
        while (parent[A] > 0) {
            visited[A] = true;
            A = parent[A];
        }

        while (parent[B] > 0) {
            if (visited[B]) {
                return B;
            }
            B = parent[B];
        }
        return A;
    }

}