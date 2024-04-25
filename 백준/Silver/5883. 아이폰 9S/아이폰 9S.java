import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        boolean[] visited = new boolean[1_000_001];
        int max = 0;
        //1000^2
        for (int i = 0; i < N; i++) {// 제외 시킬 애
            if (visited[arr[i]]) continue;
            visited[arr[i]] = true;
            int cnt = 0;
            int prev = 0;
            for (int j = 0; j < N; j++) { // 순회 시작
                if (arr[j] == arr[i]) {
                    continue;
                }
                if (arr[j] != arr[prev]) {
                    max = Math.max(max, cnt);
                    cnt = 0;
                }
                cnt++;
                prev = j;
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }

}

