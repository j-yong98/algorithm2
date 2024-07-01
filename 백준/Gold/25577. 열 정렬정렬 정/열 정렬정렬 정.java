import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[][] arr;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i][0] = i;
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));
        int[] temp = new int[N];
        for (int i = 0; i < N; i++) {
            temp[arr[i][0]] = i;
        }
        boolean[] check = new boolean[N];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (check[i]) continue;
            cnt++;
            int j = i;
            while (!check[j]) {
                check[j] = true;
                j = temp[j];
            }
        }
        System.out.println(N - cnt);
    }
}