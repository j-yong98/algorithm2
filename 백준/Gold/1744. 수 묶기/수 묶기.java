import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] arr;
    /**
     * 수 묶기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int sum = 0;
        int left = 0;
        int right = N - 1;
        for (; left < right; left += 2) {
            if (arr[left] < 1 && arr[left + 1] < 1)
                sum += arr[left] * arr[left + 1];
            else
                break;
        }
        for (; left < right; right -= 2) {
            if (arr[right] > 1 && arr[right - 1] > 1)
                sum += arr[right] * arr[right - 1];
            else
                break;
        }
        for (; left <= right; right--)
            sum += arr[right];
        System.out.println(sum);
        br.close();
    }
}