import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int Q;
    static long add = 0;
    static long mul = 1;
    static long cur = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int q = 0; q < Q; q++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            switch (cmd) {
                case 0:
                    cur += Integer.parseInt(st.nextToken());
                    break;
                case 1:
                    int val = Integer.parseInt(st.nextToken());
                    cur *= val;
                    mul *= val;
                    break;
                case 2:
                    val = Integer.parseInt(st.nextToken());
                    cur += (mul * val);
                    break;
                case 3:
                    sb.append(cur).append("\n");
                    break;
            }
        }
        System.out.print(sb);
    }
}