import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /**
     * 체커
     * 100만, 100만의 좌표 탐색
     * -> 시간이 너무 오래걸림, 필요한 부분만 탐색하기
     * 50개의 좌표의 x와 y값만을 가지고 찾기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] ans = new int[N];
        Arrays.fill(ans, Integer.MAX_VALUE);
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                int[] tmp = new int[N];
                for (int i = 0; i < N; i++) {
                    tmp[i] = Math.abs(arr[x][0] - arr[i][0]) + Math.abs(arr[y][1] - arr[i][1]);
                }

                Arrays.sort(tmp); //가까운 순서부터 k개 점 모으기
                int k = 0;
                for (int i = 0; i < N; i++) {
                    k += tmp[i];
                    ans[i] = Math.min(ans[i], k);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }
}