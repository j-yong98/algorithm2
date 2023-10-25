
import java.io.*;

public class Main {
    static final int SIZE = 3;
    static int T;
    static Cube cube;

    /**
     * 큐빙
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            cube = new Cube();
            int n = Integer.parseInt(br.readLine());
            String[] line = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                turn(line[i].charAt(0), line[i].charAt(1));
            }
            for (int r = 0; r < SIZE; r++) {
                for (int c = 0; c < SIZE; c++) {
                    bw.write(cube.up[r][c]);
                }
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void turn(char side, char dir) {
        Cube tmp = new Cube();
        setCube(side, cube, tmp);
        if (dir == '+')
            rotate(tmp);
        else
            rRotate(tmp);
        setCube(getSide(side), tmp, cube);
    }

    private static char getSide(char side) {
        if (side == 'U')
            return 'D';
        if (side == 'D')
            return 'U';
        if (side == 'F')
            return 'F';
        if (side == 'B')
            return 'B';
        if (side == 'L')
            return 'R';
        if (side == 'R')
            return 'L';
        throw new IllegalArgumentException();
    }

    private static void rotate(Cube c) {
        char[][] tmp = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++)
                tmp[j][SIZE - i - 1] = c.front[i][j];
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++)
                c.front[i][j] = tmp[i][j];
        }

        char[] t = new char[SIZE];
        for (int i = 0; i < SIZE; i++)
            t[i] = c.up[SIZE - 1][i];
        for (int i = 0; i < SIZE; i++)
            c.up[SIZE - 1][i] = c.left[SIZE - i - 1][SIZE - 1];
        for (int i = 0; i < SIZE; i++)
            c.left[i][SIZE - 1] = c.down[SIZE - 1][i];
        for (int i = 0; i < SIZE; i++)
            c.down[SIZE - 1][i] = c.right[SIZE - i - 1][0];
        for (int i = 0; i < SIZE; i++)
            c.right[i][0] = t[i];
    }

    private static void rRotate(Cube c) {
        char[][] tmp = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++)
                tmp[i][j] = c.front[j][SIZE - i - 1];
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++)
                c.front[i][j] = tmp[i][j];
        }

        char[] t = new char[SIZE];
        for (int i = 0; i < SIZE; i++)
            t[i] = c.up[SIZE - 1][i];
        for (int i = 0; i < SIZE; i++)
            c.up[SIZE - 1][i] = c.right[i][0];
        for (int i = 0; i < SIZE; i++)
            c.right[i][0] = c.down[SIZE - 1][SIZE - i - 1];
        for (int i = 0; i < SIZE; i++)
            c.down[SIZE - 1][i] = c.left[i][SIZE - 1];
        for (int i = 0; i < SIZE; i++)
            c.left[i][SIZE - 1] = t[SIZE - i - 1];
    }

    private static void setCube(char side, Cube src, Cube dst) {
        if (side == 'U') {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    dst.up[i][j] = src.back[SIZE - i - 1][j];
            }
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    dst.down[i][j] = src.front[SIZE - i - 1][j];
            }
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    dst.front[i][j] = src.up[i][j];
            }
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    dst.back[i][j] = src.down[i][j];
            }
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    dst.left[j][SIZE - i - 1] = src.left[i][j];
            }
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    dst.right[i][j] = src.right[j][SIZE - i - 1];
            }
        }
        else if (side == 'D') {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    dst.up[i][j] = src.front[i][j];
            }
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    dst.down[i][j] = src.back[i][j];
            }
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    dst.front[i][j] = src.down[SIZE - i - 1][j];
            }
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    dst.back[i][j] = src.up[SIZE - i - 1][j];
            }
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    dst.left[i][j] = src.left[j][SIZE - i - 1];
            }
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    dst.right[j][SIZE - i - 1] = src.right[i][j];
            }
        }
        else if (side == 'F') {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    dst.up[i][j] = src.up[i][j];
            }
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    dst.down[i][j] = src.down[i][j];
            }
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    dst.front[i][j] = src.front[i][j];
            }
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    dst.back[i][j] = src.back[i][j];
            }
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    dst.left[i][j] = src.left[i][j];
            }
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    dst.right[i][j] = src.right[i][j];
            }
        }
        else if (side == 'B') {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    dst.up[i][j] = src.up[SIZE - i - 1][SIZE - j - 1];
            }
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    dst.down[i][j] = src.down[SIZE - i - 1][SIZE - j - 1];
            }
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    dst.front[i][j] = src.back[i][SIZE - j - 1];
            }
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    dst.back[i][j] = src.front[i][SIZE - j - 1];
            }
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    dst.left[i][j] = src.right[i][j];
            }
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    dst.right[i][j] = src.left[i][j];
            }
        }
        else if (side == 'L') {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    dst.up[i][j] = src.up[j][SIZE - i - 1];
            }
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    dst.down[i][j] = src.down[j][SIZE - i - 1];
            }
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    dst.front[i][j] = src.left[i][j];
            }
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    dst.back[i][j] = src.right[i][SIZE - j - 1];
            }
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    dst.left[i][j] = src.back[i][SIZE - j - 1];
            }
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    dst.right[i][j] = src.front[i][j];
            }
        }
        else if (side == 'R') {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    dst.up[j][SIZE - i - 1] = src.up[i][j];
            }
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    dst.down[j][SIZE - i - 1] = src.down[i][j];
            }
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    dst.front[i][j] = src.right[i][j];
            }
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    dst.back[i][j] = src.left[i][SIZE - j - 1];
            }
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    dst.left[i][j] = src.front[i][j];
            }
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    dst.right[i][j] = src.back[i][SIZE - j - 1];
            }
        }
    }

    static class Cube {
        char[][] up = new char[SIZE][SIZE];
        char[][] down = new char[SIZE][SIZE];
        char[][] left = new char[SIZE][SIZE];
        char[][] right = new char[SIZE][SIZE];
        char[][] front = new char[SIZE][SIZE];
        char[][] back = new char[SIZE][SIZE];

        public Cube() {
            setSide(up, 'w');
            setSide(down, 'y');
            setSide(left, 'g');
            setSide(right, 'b');
            setSide(front, 'r');
            setSide(back, 'o');
        }

        private void setSide(char[][] side, char color) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++)
                    side[i][j] = color;
            }
        }
    }
}
