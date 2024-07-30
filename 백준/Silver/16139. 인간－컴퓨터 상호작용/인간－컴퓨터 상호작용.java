import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    /**
     * 인간-컴퓨터 상호작용
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        arr = new int[26][str.length()];
        for (int i = 0; i < str.length(); i++) {
            int ch = str.charAt(i) - 'a';
            if (i > 0) {
                for (int j = 0; j < 26; j++) {
                    arr[j][i] = arr[j][i - 1];
                }
            }
            arr[ch][i]++;
        }
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 'a';
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if (s == 0) {
                sb.append(arr[a][e]);
            } else {
                sb.append(arr[a][e] - arr[a][s - 1]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}