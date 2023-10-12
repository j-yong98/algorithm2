import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static final int TOP = 0;
    static final int LEFT = 6;
    static final int RIGHT = 2;
    static int T, K;
    static LinkedList<Integer>[] arr;
    static int[] checkDir;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        arr = new LinkedList[T];
        checkDir = new int[T];
        visited = new boolean[T];
        for (int i = 0; i < T; i++)
            arr[i] = new LinkedList<>();
        for (int i = 0; i < T; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++)
                arr[i].add(line.charAt(j) - '0');
        }
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            checkDir[num] = dir;
            simulate(num);
            Arrays.fill(checkDir, 0);
            Arrays.fill(visited, false);
        }
        System.out.println(countS());
    }

    private static int countS() {
        int cnt = 0;
        for (int i = 0; i < T; i++) {
            if (arr[i].get(TOP) == 1)
                cnt++;
        }
        return cnt;
    }

    private static void simulate(int num) {
        visited[num] = true;
        //왼쪽
        if (num > 0 && !visited[num - 1]) {
            if ((arr[num].get(LEFT) ^ arr[num - 1].get(RIGHT)) == 1) {
                checkDir[num - 1] = -checkDir[num];
                simulate(num - 1);
            }
        }
        //오른쪽
        if (num < T - 1 && !visited[num + 1]) {
            if ((arr[num].get(RIGHT) ^ arr[num + 1].get(LEFT)) == 1) {
                checkDir[num + 1] = -checkDir[num];
                simulate(num + 1);
            }
        }
        rotate(num, checkDir[num]);
    }

    private static void rotate(int num, int dir) {
        if (dir == 1)
            arr[num].addFirst(arr[num].pollLast());
        else
            arr[num].addLast(arr[num].pollFirst());
    }
}