import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N;

    /**
     * 증가하는 수
     * 수를 다 보면 시간 초과
     * 증가하는 수만 보자
     * 자리 수 - 1 수부터 증가하는 수 가능
     * 현재 자리에 가능한 수는 이전 수 - 1 개
     * 최대가 9876543210 1022번째
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if (N < 10) {
            System.out.println(N);
        } else if (N > 1022) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < 10; i++) {
                f(1, i);
            }
            list.sort(Long::compare);
            System.out.println(list.get(N));
        }
    }

    static List<Long> list = new ArrayList<>();
    private static void f(int n, long num) {
        if (n > 10) {
            return;
        }

        list.add(num);
        for (int i = 0; i < num % 10; i++) {
            f(n + 1, num * 10 + i);
        }
    }
}