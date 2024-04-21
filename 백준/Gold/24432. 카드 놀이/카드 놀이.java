import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static int N, M, K;
    static int[] A;
    static int[] B;
    static List<Integer> aList;
    static List<Integer> bList;

    /**
     * 카드 놀이
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            A = new int[N];
            B = new int[M];
            aList = new ArrayList<>();
            bList = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }
            f(N, 0, 0, 0, A, aList);
            f(M, 0, 0, 0, B, bList);
            Collections.sort(aList);
            Collections.sort(bList);
            int min = Integer.MAX_VALUE;
            int max = Math.max(
                    Math.abs(bList.get(bList.size() - 1) - aList.get(0)),
                    Math.abs(aList.get(aList.size() - 1) - bList.get(0))
            );
            for (int i = 0; i < aList.size(); i++) {
                int a = aList.get(i);
                int l = 0;
                int r = bList.size() - 1;

                while (l <= r) {
                    int m = (l + r) >> 1;

                    int b = bList.get(m);
                    if (b == a) {
                        min = 0;
                        break;
                    }
                    if (a > b) {
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                    min = Math.min(min, Math.abs(a - b));
                }
            }
            sb.append(min).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static void f(int n, int k, int s, int sum, int[] arr, List<Integer> tmp) {
        if (k == K) {
            tmp.add(sum);
            return;
        }
        for (int i = s; i < n; i++) {
            f(n, k + 1, i + 1, sum + arr[i], arr, tmp);
        }
    }
}