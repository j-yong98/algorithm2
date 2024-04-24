import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int a, b, n, w;

    /**
     * Farm
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        br.close();

        List<Integer> tmp = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if ((a * i) + ((n - i) * b) == w)
                tmp.add(i);
        }
        if (tmp.size() != 1) {
            System.out.println(-1);
        } else {
            int aa = tmp.get(0);
            System.out.println(aa + " " + (n - aa));
        }
    }
}