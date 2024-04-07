import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<int[]> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr.add(new int[]{s, e});
        }
        Collections.sort(arr, (a, b)-> a[0] - b[0]);
        long len = 0;
        int s = arr.get(0)[0];
        int e = arr.get(0)[1];
        for (int i = 1; i < n; i++) {
            if (e >= arr.get(i)[0])
                e = Math.max(e, arr.get(i)[1]);
            else {
                len += e - s;
                s = arr.get(i)[0];
                e = arr.get(i)[1];
            }
        }
        len += e - s;
        bw.write(len + "\n");
        bw.flush();
        bw.close();
    }
}
