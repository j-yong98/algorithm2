import java.util.*;
class Solution {
    final int MAX = 51;
    final int[] dy = {-1, 1, 0, 0};
    final int[] dx = {0, 0, -1, 1};
    List<int[][]> puzzles = new ArrayList<>();
    List<int[][]> blanks = new ArrayList<>();
    boolean[] checkPuzzle;
    boolean[] checkBlank;
    int answer = 0;
    public int solution(int[][] game_board, int[][] table) {
        int blankCount = getPuzzles(game_board, 0, blanks);
        int puzzleCount = getPuzzles(table, 1, puzzles);
        checkBlank = new boolean[blankCount];
        checkPuzzle = new boolean[puzzleCount];
        for (int i = 0; i < 4; i++) {
            getFitPuzzle();
            rotatePuzzle();
        }
        System.out.println(Arrays.toString(checkBlank));
        for (int i = 0; i < checkBlank.length; i++) {
            if (checkBlank[i]) {
                answer += getCount(blanks.get(i), 1);
            }
        }
        return answer;
    }
    
    private void getFitPuzzle() {
        int len = blanks.size();
        for (int i = 0; i < puzzles.size(); i++) {
            if (checkPuzzle[i]) continue;
            int[][] puzzle = puzzles.get(i);
            for (int j = 0; j < blanks.size(); j++) {
                if (checkBlank[j]) continue;
                int[][] blank = blanks.get(j);
                if (isFit(puzzle, blank)) {
                    checkPuzzle[i] = true;
                    checkBlank[j] = true;
                    break;
                }
            }
        }
    }
    
    private boolean isFit(int[][] src, int[][] dst) {
        int h1 = src.length;
        int w1 = src[0].length;
        int h2 = dst.length;
        int w2 = dst[0].length;
        if (h1 != h2 || w1 != w2) return false;
        
        for (int i = 0; i < h1; i++) {
            for (int j = 0; j < w1; j++) {
                if (src[i][j] != dst[i][j]) return false;
            }
        }
        return true;
    }
    
    private int getCount(int[][] board, int val) {
        int cnt = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == val) cnt += 1;
            }
        }
        return cnt;
    }
    
    
    
    private int[][] makePuzzle(List<int[]> puzzle) {
        int minY = MAX, maxY = 0, minX = MAX, maxX = 0;
        for (int[] pos : puzzle) {
            minY = Math.min(minY, pos[0]);
            maxY = Math.max(maxY, pos[0]);
            minX = Math.min(minX, pos[1]);
            maxX = Math.max(maxX, pos[1]);
        }
        int h = maxY - minY + 1;
        int w = maxX - minX + 1;
        int[][] p = new int[h][w];
        for (int[] pos : puzzle) {
            p[pos[0] - minY][pos[1] - minX] = 1;
        }
        return p;
    }
    
    private void printMap(int[][] table) {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    private void rotatePuzzle() {
        List<int[][]> tmp = new ArrayList<>();
        for (int i = 0; i < puzzles.size(); i++) {
            int[][] puzzle = puzzles.get(i);
            tmp.add(rotate(puzzle));
        }
        puzzles = tmp;
    }
    
    private int[][] rotate(int[][] board) {
        int N = board.length;
        int M = board[0].length;
        
        int[][] tmp = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[j][N - i - 1] = board[i][j];
            }
        }
        return tmp;
    }
    
    private int getPuzzles(int[][] board, int val, List<int[][]> list) {
        int cnt = 0;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != val || visited[i][j]) continue;
                list.add(makePuzzle(bfs(i, j, board, visited, val)));
                cnt += 1;
            }
        }
        return cnt;
    }
    
    private List<int[]> bfs(int y, int x, int[][] board, boolean[][] visited, int val) {
        List<int[]> puzzle = new ArrayList<>();
        Deque<int[]> q = new ArrayDeque<>();
        
        puzzle.add(new int[]{y, x});
        q.add(puzzle.get(puzzle.size() - 1));
        visited[y][x] = true;
        
        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();
            
            for (int i = 0; i < 4; i++) {
                int yy = pos[0] + dy[i];
                int xx = pos[1] + dx[i];
                if (!inRange(yy, xx, board.length, board[0].length) || visited[yy][xx] || board[yy][xx] != val) continue;
                puzzle.add(new int[]{yy, xx});
                q.add(puzzle.get(puzzle.size() - 1));
                visited[yy][xx] = true;
            }
        }
        return puzzle;
    }
    
    private boolean inRange(int y, int x, int N, int M) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}