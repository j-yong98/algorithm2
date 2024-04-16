import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] powers;
    static int[] arr;
    static Map<Integer, String> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        powers = new int[N];
        arr = new int[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int power = Integer.parseInt(st.nextToken());
            powers[i] = power;
            if (!map.containsKey(power)) {
                map.put(power, name);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            int l = 0;
            int r = N;

            while (l < r) {
                int mid = (l + r) >> 1;

                if (powers[mid] < arr[i]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            sb.append(map.get(powers[r])).append("\n");
        }

        System.out.println(sb);
    }

}

