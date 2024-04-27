import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int VIRUS = 2;
    static int n,m;
    static int[][] arr;
    static int[][] dist;
    static List<int[]> virus = new ArrayList<>();
    static List<int[]> selectedVirus = new ArrayList<>();
    static Queue<int[]> q = new LinkedList<>();
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int ans = Integer.MAX_VALUE;
    private static void init(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                dist[i][j] = -1;
            }
        }
        for (int i = 0; i < selectedVirus.size(); i++){
            int[] pos = selectedVirus.get(i);
            q.add(pos);
            dist[pos[0]][pos[1]] = 0;
        }
    }
    private static boolean inRange(int y, int x){
        return y >= 0 && y < n && x >= 0 && x < n && (arr[y][x] == 0 || arr[y][x] == VIRUS) && dist[y][x] == -1;
    }
    private static void bfs(){
        init();
        while(!q.isEmpty()){
            int[] pos = q.poll();
            for (int i = 0; i < 4; i++){
                int y = pos[0] + dy[i];
                int x = pos[1] + dx[i];
                if (inRange(y,x)){
                    q.add(new int[]{y,x});
                    dist[y][x] = dist[pos[0]][pos[1]] + 1;
                }
            }
        }
    }
    private static int findMin(){
        int value = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (arr[i][j] == 0 && dist[i][j] == -1) return Integer.MAX_VALUE;
                if (arr[i][j] == 0) value = Math.max(value, dist[i][j]);
            }
        }
        return value;
    }
    private static void f(int l){
        if (l == virus.size() || selectedVirus.size() == m){
            bfs();
            int min = findMin();
            ans = Math.min(ans,min);
            return;
        }
        selectedVirus.add(virus.get(l));
        f(l+1);
        selectedVirus.remove(virus.get(l));
        f(l+1);
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        dist = new int[n][n];
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                int now = Integer.parseInt(st.nextToken());
                arr[i][j] = now;
                if (now == VIRUS)  virus.add(new int[]{i,j});
            }
        }
        f(0);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}
