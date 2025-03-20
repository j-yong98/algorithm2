import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static int K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        int k = K + 1;
        int[] arr = new int[32];
        int i;
        for (i = 0; (k >> i) > 1; i++) {
            int bit = (k >> i) & 1;
            if (bit == 0) {
                bit = 4;
            } else {
                bit = 7;
            }
            arr[i] = bit;
        }
        StringBuilder sb = new StringBuilder();
        for (i = i - 1; i >= 0; i--) {
            sb.append(arr[i]);
        }
        System.out.println(sb);
    }
}