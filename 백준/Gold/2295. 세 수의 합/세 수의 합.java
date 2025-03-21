import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        List<Integer> sum = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum.add(arr[i] + arr[j]);
            }
        }

        Arrays.sort(arr);
        sum.sort(Integer::compare);

        for (int k = N - 1; k >= 0; k--) {
            for (int d = N - 1; d >= 0; d--) {
                int t = arr[k] - arr[d];
                int l = 0;
                int r = sum.size() - 1;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (sum.get(mid) == t) {
                        System.out.println(arr[k]);
                        return;
                    } else if (sum.get(mid) < t) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }
        }
    }
}