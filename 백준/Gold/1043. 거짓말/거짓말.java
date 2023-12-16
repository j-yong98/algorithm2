import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean[] arr;
    static int[] parent;
    static List<Integer>[] party;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new boolean[N + 1];
        parent = new int[N + 1];
        party = new List[M];
        for (int i = 0; i < M; i++)
            party[i] = new ArrayList<>();
        for (int i = 1; i <= N; i++)
            parent[i] = i;
        st = new StringTokenizer(br.readLine());
        int known = Integer.parseInt(st.nextToken());
        for (int i = 0; i < known; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[num] = true;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int come = Integer.parseInt(st.nextToken());
            int pre = Integer.parseInt(st.nextToken());
            party[i].add(pre);
            for (int j = 0; j < come - 1; j++) {
                int person = Integer.parseInt(st.nextToken());
                party[i].add(person);
                union(pre, person);
            }
        }

        for (int i = 1; i <= N; i++) {
            if (arr[i]) {
                for (int j = 1; j <= N; j++) {
                    if (i == j || arr[j]) continue;
                    if (findParent(i) == findParent(j))
                        arr[j] = true;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            for (Integer p : party[i]) {
                if (!arr[p]) continue;
                cnt++;
                break;
            }
        }
        System.out.println(M - cnt);
    }

    private static void union(int a, int b) {
        int p1 = findParent(a);
        int p2 = findParent(b);

        if (p1 < p2)
            parent[p2] = p1;
        else
            parent[p1] = p2;
    }

    private static int findParent(int idx) {
        if (parent[idx] == idx) return idx;
        return findParent(parent[idx]);
    }
}
