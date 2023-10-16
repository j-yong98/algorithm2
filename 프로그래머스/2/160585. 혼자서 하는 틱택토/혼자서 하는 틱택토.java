class Solution {
    final int N = 3;
    final int BLANK = 0;
    final int FIRST = 1;
    final int SECOND = 2;
    int[][] arr;
    int cnt = 0;
    boolean isPossible = false;
    public int solution(String[] board) {
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = board[i].charAt(j) == '.' ? BLANK : board[i].charAt(j) == 'O' ? FIRST : SECOND;
                if (arr[i][j] != BLANK)
                    cnt++;
            }
        }
        simulate(0, new int[N][N], FIRST);
        if (isPossible)
            return 1;
        return 0;
    }
    
    private void simulate(int c, int[][] tmp, int turn) {
        if (isPossible) return;
        if (c == cnt) {
            if (isEqual(arr, tmp))
                isPossible = true;
            return;
        }
        if (isFinish(tmp) != 0) return;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tmp[i][j] != BLANK) continue;
                tmp[i][j] = turn;
                simulate(c + 1, tmp, turn ^ 3);
                tmp[i][j] = BLANK;
            }
        }
    }
    
    private boolean isEqual(int[][] a, int[][] b) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (a[i][j] != b[i][j]) return false;
            }
        }
        return true;
    }
    
    private int isFinish(int[][] tmp) {
        for (int i = 0; i < N; i++) {
            int a = 1;
            for (int j = 1; j < N; j++) {
                if (tmp[i][j] == BLANK || tmp[i][j] != tmp[i][j - 1]) break;
                a++;
            }
            if (a == 3) return tmp[i][0];
        }
        
        for (int i = 0; i < N; i++) {
            int a = 1;
            for (int j = 1; j < N; j++) {
                if (tmp[j][i] == BLANK || tmp[j][i] != tmp[j - 1][i]) break;
                a++;
            }
            if (a == 3) return tmp[0][i];
        }
        
        int a = 1;
        for (int i = 1; i < N; i++) {
            if (tmp[i][i] != tmp[i - 1][i - 1]) break;
            a++;
        }
        if (a == 3) return tmp[0][0];
        
        a = 1;
        for (int i = 1; i < N; i++) {
            if (tmp[i][N - i - 1] != tmp[i - 1][N - (i - 1) - 1]) break;
            a++;
        }
        
        if (a == 3) return tmp[0][N - 1];
        return 0;
    }
}