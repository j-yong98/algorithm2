import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    private static Deque<Integer> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        if (num == 0)
            System.out.println(1);
        else {
            int tmp = num;
            while (num > 0) {
                q.addFirst(num % 10);
                num /= 10;
            }
            if (q.size() == 1)
                q.addFirst(0);
            int cnt = 0;
            do {
                int a = q.pollFirst();
                int b = q.peekFirst();
                q.addLast((a + b) % 10);
                cnt++;
            } while (!isEqual(tmp));
            System.out.println(cnt);
        }
        br.close();
    }

    private static boolean isEqual(int target) {
        int len = q.size();
        for (int i = 0; i < len; i++) {
            int a = q.pollFirst();
            int b = q.pollFirst();
            if (a * 10 + b == target) return true;
            q.addLast(a);
            q.addLast(b);
        }
        return false;
    }
}