
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static final int SIZE = 3;
    static final int MATTER_SIZE = 4;
    static final int KILN_SIZE = 5;

    static int N;
    static Matter[][][][] matters;
    static int ans = 0;

    /**
     * 피아의 아틀리에 ~신비한 대회의 연금술사~
     **/
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        matters = new Matter[N][4][MATTER_SIZE][MATTER_SIZE];
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < MATTER_SIZE; i++) {
                for (int j = 0; j < MATTER_SIZE; j++)
                    matters[k][0][i][j] = new Matter();
            }
        }
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < MATTER_SIZE; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < MATTER_SIZE; j++)
                    matters[k][0][i][j].effec = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < MATTER_SIZE; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < MATTER_SIZE; j++)
                    matters[k][0][i][j].color = st.nextToken().charAt(0);
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 1; i < 4; i++)
                matters[k][i] = rotatePick(matters[k][i - 1]);
        }
        pickMatter(0, makeKiln(), 0);

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }

    private static Matter[][] makeKiln() {
        Matter[][] kiln = new Matter[KILN_SIZE][KILN_SIZE];

        for (int i = 0; i < KILN_SIZE; i++) {
            for (int j = 0; j < KILN_SIZE; j++)
                kiln[i][j] = new Matter();
        }

        return kiln;
    }

    private static void pickMatter(int l, Matter[][] kiln, int visited) {
        if (l == SIZE) {
            ans = Math.max(ans, getQuality(kiln));
            return ;
        }

        for (int k = 0; k < N; k++) {
            if ((visited & (1 << k)) == 0) {

                for (int i = 0; i <= 1; i++) {
                    for (int j = 0; j <= 1; j++) {

                        for (int d = 0; d < 4; d++) {
                            Matter[][] tmp = putMatter(copyKiln(makeKiln(), kiln), matters[k][d], i, j);
                            pickMatter(l + 1, tmp, visited | (1 << k));
                        }
                    }
                }

            }
        }

    }

    public static Matter[][] rotatePick(Matter[][] pick) {
        Matter[][] tmp = makeKiln();

        for (int i = 0; i < MATTER_SIZE; i++) {
            for (int j = 0; j < MATTER_SIZE; j++) {
                tmp[i][j].effec = pick[j][MATTER_SIZE - i - 1].effec;
                tmp[i][j].color = pick[j][MATTER_SIZE - i - 1].color;
            }
        }
        return tmp;
    }

    private static Matter[][] putMatter(Matter[][] tmp, Matter[][] pick, int y, int x) {
        for (int i = 0; i < MATTER_SIZE; i++) {
            for (int j = 0; j < MATTER_SIZE; j++) {
                tmp[y + i][x + j].effec += pick[i][j].effec;
                if (tmp[y + i][x + j].effec < 0)
                    tmp[y + i][x + j].effec = 0;
                else if (tmp[y + i][x + j].effec > 9)
                    tmp[y + i][x + j].effec = 9;
                if (pick[i][j].color != 'W')
                    tmp[y + i][x + j].color = pick[i][j].color;
            }
        }

        return tmp;
    }

    private static Matter[][] copyKiln(Matter[][] dst, Matter[][] src) {
        for (int i = 0; i < KILN_SIZE; i++) {
            for (int j = 0; j < KILN_SIZE; j++) {
                dst[i][j].effec = src[i][j].effec;
                dst[i][j].color = src[i][j].color;
            }
        }
        return dst;
    }

    private static int getQuality(Matter[][] kiln) {
        int r = 0, b = 0, g = 0, y = 0;

        for (int i = 0; i < KILN_SIZE; i++) {
            for (int j = 0; j < KILN_SIZE; j++) {
                if (kiln[i][j].color == 'R')
                    r += kiln[i][j].effec;
                else if (kiln[i][j].color == 'B')
                    b += kiln[i][j].effec;
                else if (kiln[i][j].color == 'G')
                    g += kiln[i][j].effec;
                else if (kiln[i][j].color == 'Y')
                    y += kiln[i][j].effec;
            }
        }

        return 7 * r + 5 * b + 3 * g + 2 * y;
    }
    static class Matter{
        int effec;
        char color;

        public Matter() {
            this.effec = 0;
            this.color = 'W';
        }
    }
}
