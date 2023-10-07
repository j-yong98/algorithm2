import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int T;
    static int[] arr;
    /**
     * 에너그램
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            char[] tmp = br.readLine().toCharArray();
            arr = new int[tmp.length];
            for (int i = 0; i < tmp.length; i++)
                arr[i] = tmp[i] - 'a';
            Arrays.sort(arr);
            do {
                for (int i = 0; i < arr.length; i++)
                    sb.append((char) (arr[i] + 'a'));
                sb.append("\n");
            } while(np());
        }
        System.out.print(sb);
        br.close();
    }

    private static boolean np() {
        int i = arr.length - 1;
        while (i > 0 && arr[i - 1] >= arr[i])
            i--;

        if (i == 0) return false;

        int j = arr.length - 1;
        while (arr[i - 1] >= arr[j])
            j--;
        swap(i - 1, j);

        int k = arr.length - 1;
        while (i < k) swap(i++, k--);

        return true;
    }

    private static void swap(int a, int b) {
        arr[a] ^= arr[b];
        arr[b] ^= arr[a];
        arr[a] ^= arr[b];
    }
}