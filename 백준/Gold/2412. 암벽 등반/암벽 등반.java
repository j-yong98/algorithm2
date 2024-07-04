import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N, T;
    static int[] d = {-2, -1, 0, 1, 2};
    static Set<Pos> set = new HashSet<>();
    static Set<Pos> checked = new HashSet<>();
    /**
     * 암벽 등반
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            set.add(new Pos(y, x));
        }
        br.close();

        Deque<Pos> q = new ArrayDeque<>();
        q.add(new Pos(0, 0, 0));
        while (!q.isEmpty()) {
            Pos now = q.pollFirst();

            if (now.y == T) {
                System.out.println(now.cnt);
                return;
            }

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    int y = now.y + d[i];
                    int x = now.x + d[j];
                    if (y < 0 || x < 0) {
                        continue;
                    }

                    Pos next = new Pos(y, x, now.cnt + 1);
                    if (checked.contains(next) || !set.contains(next)) {
                        continue;
                    }
                    checked.add(next);
                    q.add(next);
                }
            }
        }
        System.out.println(-1);
    }

    static class Pos {
        int y;
        int x;
        int cnt;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
            this.cnt = 0;
        }

        public Pos(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pos pos = (Pos) o;
            return y == pos.y && x == pos.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }

    }
}