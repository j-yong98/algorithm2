import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    static final String quack = "quack";
    static List<int[]> list = new ArrayList<>();
    static char[] q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        q = br.readLine().toCharArray();
        boolean flag = true;
        for (int i = 0; i < q.length; i++) {
            int idx = getIdx(q[i]);
            if (list.isEmpty()) {
                if (idx == 0) {
                    list.add(new int[]{idx, 1});
                } else {
                    flag = false;
                    break;
                }
            } else {
                int next = in(idx);
                if (next != -1) {
                    int[] arr = list.get(next);
                    arr[0] = idx;
                    arr[1]++;
                } else if (idx == 0) {
                    list.add(new int[]{idx, 1});
                } else {
                    flag = false;
                    break;
                }
            }
        }
        int ans = 0;
        if (flag) {
            for (int[] arr : list) {
                if (arr[1] % quack.length() == 0) {
                    ans++;
                } else {
                    ans = 0;
                    break;
                }
            }
        }
        System.out.println(ans == 0 ? -1 : ans);
        br.close();
    }

    private static int in(int idx) {
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i)[0] + 1) % quack.length() == idx) {
                return i;
            }
        }
        return -1;
    }

    private static int getIdx(char c) {
        return quack.indexOf(c);
    }
}