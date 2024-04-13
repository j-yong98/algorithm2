import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int N = 0;
    static int T;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int dir;
    static int[] pos;
    static int rMax, rMin, cMax, cMin;
    /**
     * 거북이
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            pos = new int[]{N, N};
            dir = 0;
            rMax = rMin = cMax = cMin = 0;
            char[] cmd = br.readLine().toCharArray();
            for (int i = 0; i < cmd.length; i++) {
                if (cmd[i] == 'F') {
                    pos[0] = pos[0] + dy[dir];
                    pos[1] = pos[1] + dx[dir];
                } else if (cmd[i] == 'B') {
                    int rDir = (dir + 2) % 4;
                    pos[0] = pos[0] + dy[rDir];
                    pos[1] = pos[1] + dx[rDir];
                } else if (cmd[i] == 'L') {
                    dir = (dir + 1) % 4;
                } else {
                    dir = (dir - 1 + 4) % 4;
                }
                rMax = Math.max(rMax, pos[0]);
                rMin = Math.min(rMin, pos[0]);
                cMax = Math.max(cMax, pos[1]);
                cMin = Math.min(cMin, pos[1]);
            }
            int ans = Math.abs(rMax - rMin) * Math.abs(cMax - cMin);
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}