
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int G, P;
    static int[] parent;
    /**
     * 공항
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        parent = new int[G + 1];
        for (int i = 1; i <= G; i++)
            parent[i] = i;
        int ans = 0;
        for (int i = 0; i < P; i++) {
            int g = Integer.parseInt(br.readLine());

            int gate = find(g);
            if (gate == 0)
                break;

            ans++;
            union(gate - 1, gate);
        }
        System.out.println(ans);
        br.close();
    }

    private static int find(int a) {
        if (a == parent[a]) return a;
        return parent[a] = find(parent[a]);
    }

    private static void union(int a, int b) {
        int p1 = find(a);
        int p2 = find(b);

        if (p1 != p2)
            parent[p2] = parent[p1];
    }
}
