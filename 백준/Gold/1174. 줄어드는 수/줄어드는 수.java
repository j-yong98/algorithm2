import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int N;
    static final int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    static List<Long> list = new ArrayList<>();

    /**
     * 줄어드는 수
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        getDecreaseNumber(0, 0);
        Collections.sort(list);

        try {
            System.out.println(list.get(N - 1));
        } catch(Exception e) {
            System.out.println(-1);
        }
        br.close();
    }

    private static void getDecreaseNumber(long num, int idx) {
        if (!list.contains(num)) {
            list.add(num);
        }

        if (idx >= 10) {
            return;
        }

        getDecreaseNumber(num * 10 + arr[idx], idx + 1);
        getDecreaseNumber(num, idx + 1);
    }
}