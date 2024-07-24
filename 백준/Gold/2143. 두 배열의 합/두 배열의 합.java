import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static List<Integer> list1 = new ArrayList<>();
    static List<Integer> list2 = new ArrayList<>();
    static int T;
    static int[] arr1;
    static int[] arr2;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        arr1 = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        arr2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        getCnt(arr1, N, list1);
        getCnt(arr2, M, list2);
        Collections.sort(list1);
        Collections.sort(list2);
        long cnt = 0;
        for (int i = 0; i < list1.size(); i++) {
            int key = T - list1.get(i);
            int l = lower(key);
            int u = upper(key);
            cnt += u - l;
        }
        System.out.println(cnt);
    }

    private static int lower(int key) {
        int l = 0;
        int r = list2.size();

        while (l < r) {
            int mid = (l + r) >> 1;

            if (list2.get(mid) < key) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }

    private static int upper(int key) {
        int l = 0;
        int r = list2.size();

        while (l < r) {
            int mid = (l + r) >> 1;

            if (list2.get(mid) <= key) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }

    private static void getCnt(int[] arr, int length, List<Integer> list) {
        for (int i = 0; i < length; i++) {
            int sum = arr[i];
            list.add(sum);
            for (int j = i + 1; j < length; j++) {
                sum += arr[j];
                list.add(sum);
            }
        }
    }
}