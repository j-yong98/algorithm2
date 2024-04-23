import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int N, K;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            List<Integer> lis = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if (i == 0 || lis.get(lis.size() - 1) < arr[i]) {
                    lis.add(arr[i]);
                } else {
                    int l = 0;
                    int r = lis.size();

                    while (l < r) {
                        int m = (l + r) >> 1;

                        if (lis.get(m) < arr[i]) {
                            l = m + 1;
                        } else {
                            r = m;
                        }
                    }
                    lis.set(r, arr[i]);
                }
            }
            sb.append("Case #").append(t).append("\n");
            sb.append(lis.size() >= K ? 1 : 0).append("\n");
        }
        System.out.println(sb);
    }
}

