import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] chicken = new int[S];

        long sum = 0;
        for(int i=0; i<S; i++) {
            chicken[i] = Integer.parseInt(br.readLine());
            sum += chicken[i];
        }

        long l = 1;
        long r = 1000000000;
        long res = 0;

        while(l <= r) {
            long mid = (l + r) / 2;

            int cnt = 0;
            for(int i=0; i<chicken.length; i++) {
                cnt += chicken[i] / mid;
            }
            if(cnt >= C) {
                res = mid;
                l = mid + 1;
            }

            else {
                r = mid - 1;
            }
        }

        long answer = sum - (res * C);
        System.out.println(answer);

    }
}