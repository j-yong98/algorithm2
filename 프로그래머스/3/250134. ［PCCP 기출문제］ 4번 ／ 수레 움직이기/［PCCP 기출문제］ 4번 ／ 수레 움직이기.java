class Solution {
    final int BLANK = 0;
    final int RED_START = 1;
    final int BLUE_START = 2;
    final int RED_END = 3;
    final int BLUE_END = 4;
    final int[] dy = {-1, 1, 0, 0};
    final int[] dx = {0, 0, -1, 1};
    int N, M;
    int ans = Integer.MAX_VALUE;
    int[][] start = new int[2][];
    int[][] end = new int[2][];
    boolean[][][] visited;
    int[][] arr;

    public int solution(int[][] maze) {
        arr = maze;
        N = maze.length;
        M = maze[0].length;
        visited = new boolean[2][N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maze[i][j] == RED_START) {
                    start[0] = new int[]{i, j};
                    arr[i][j] = BLANK;
                } else if (maze[i][j] == BLUE_START) {
                    start[1] = new int[]{i, j};
                    arr[i][j] = BLANK;
                } else if (maze[i][j] == RED_END) {
                    end[0] = new int[]{i, j};
                    arr[i][j] = BLANK;
                } else if (maze[i][j] == BLUE_END) {
                    end[1] = new int[]{i, j};
                    arr[i][j] = BLANK;
                }
            }
        }
        visited[0][start[0][0]][start[0][1]] = true;
        visited[1][start[1][0]][start[1][1]] = true;
        f(0, start[0][0], start[0][1], start[1][0], start[1][1]);
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    private void f(int cnt, int y1, int x1, int y2, int x2) {
        if (cnt >= ans) {
            return;
        }
        if (isFinish(y1, x1, y2, x2)) {
            ans = cnt;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int[] next1 = getNextPosition(y1, x1, i, 0);
            if (!check(next1[0], next1[1], 0)) {
                continue;
            }
            visited[0][next1[0]][next1[1]] = true;
            for (int j = 0; j < 4; j++) {
                int[] next2 = getNextPosition(y2, x2, j, 1);
                if (!check(next2[0], next2[1], 1)) {
                    continue;
                }
                if (next1[0] == y2 && next1[1] == x2 && next2[0] == y1 && next2[1] == x1) {
                    continue;
                }
                if (next1[0] == next2[0] && next1[1] == next2[1]) {
                    continue;
                }
                visited[1][next2[0]][next2[1]] = true;
                f(cnt + 1, next1[0], next1[1], next2[0], next2[1]);
                visited[1][next2[0]][next2[1]] = false;
            }
            visited[0][next1[0]][next1[1]] = false;
        }
    }

    private void printMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("------");
    }

    private int[] getNextPosition(int y, int x, int dir, int idx) {
        if (y == end[idx][0] && x == end[idx][1]) {
            return new int[]{y, x};
        }
        return new int[]{y + dy[dir], x + dx[dir]};
    }

    private boolean check(int y, int x, int idx) {
        if (y == end[idx][0] && x == end[idx][1]) return true;
        return inRange(y, x) && !visited[idx][y][x] && arr[y][x] == BLANK;
    }

    private boolean inRange(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }

    private boolean isFinish(int y1, int x1, int y2, int x2) {
        return y1 == end[0][0] && x1 == end[0][1] && y2 == end[1][0] && x2 == end[1][1];
    }
}