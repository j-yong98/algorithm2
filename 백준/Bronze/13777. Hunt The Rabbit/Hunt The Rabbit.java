import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int k = Integer.parseInt(br.readLine());
            if (k == 0) {
                break;
            }
            int l = 1;
            int r = 50;
            while (l <= r) {
                int mid = (l + r) >> 1;

                sb.append(mid);
                if (mid == k) {
                    break;
                } else if (mid < k) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}