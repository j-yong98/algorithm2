import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static final int SIZE = 5;

    static int N, M, Q;
    static List<List<Node>> edges = new ArrayList<>();
    static int[] parent;
    static int[] perm = new int[SIZE];
    static Map<Temp, int[]> calc = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        perm = new int[SIZE];
        for (int i = 0; i <= SIZE; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < SIZE; i++) {
            perm[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = st.nextToken().charAt(0) - 'A';
            edges.get(c).add(new Node(u, v, c));
        }

        do {
            for (int i = 1; i <= N; i++) {
                parent[i] = i;
            }
            int[] c = new int[SIZE];
            for (int i = 0; i < SIZE; i++) {
                for (Node edge : edges.get(perm[i])) {
                    if (findParent(edge.u) != findParent(edge.v)) {
                        union(edge.u, edge.v);
                        c[edge.w]++;
                    }
                }
            }
            calc.put(new Temp(perm), c);
        } while (np());

        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            order.add(i);
        }
        int[] val = new int[SIZE];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            long ans = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                val[j] = Integer.parseInt(st.nextToken());
            }

            Collections.sort(order, (a, b) -> Integer.compare(val[a], val[b]));

            int[] result = calc.get(new Temp(order));
            for (int j = 0; j < SIZE; j++) {
                ans += (long) val[order.get(j)] * result[order.get(j)];
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static int findParent(int a) {
        if (a == parent[a]) {
            return a;
        }
        return parent[a] = findParent(parent[a]);
    }

    private static void union(int a, int b) {
        int p1 = findParent(a);
        int p2 = findParent(b);

        if (p1 != p2) {
            parent[p2] = p1;
        }
    }

    private static boolean np() {
        int i = SIZE - 1;

        while (i > 0 && perm[i - 1] >= perm[i]) {
            i--;
        }

        if (i == 0) {
            return false;
        }

        int j = SIZE - 1;
        while (perm[i - 1] >= perm[j]) {
            j--;
        }
        swap(i - 1, j);

        int k = SIZE - 1;
        while (i < k) {
            swap(i++, k--);
        }
        return true;
    }

    private static void swap(int i, int j) {
        perm[i] ^= perm[j];
        perm[j] ^= perm[i];
        perm[i] ^= perm[j];
    }

    static class Temp {

        int[] order = new int[SIZE];

        public Temp(int[] order) {
            for (int i = 0; i < SIZE; i++) {
                this.order[i] = order[i];
            }
        }

        public Temp(List<Integer> list) {
            for (int i = 0; i < SIZE; i++) {
                this.order[i] = list.get(i);
            }
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || getClass() != object.getClass()) {
                return false;
            }
            Temp temp = (Temp) object;
            return Arrays.equals(order, temp.order);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(order);
        }

        @Override
        public String toString() {
            return "Temp{" +
                    "order=" + Arrays.toString(order) +
                    '}';
        }
    }

    static class Node {

        int u;
        int v;
        int w;

        public Node(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "u=" + u +
                    ", v=" + v +
                    ", w=" + w +
                    '}';
        }
    }
}