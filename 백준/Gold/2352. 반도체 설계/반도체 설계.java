class Main {
    static int N;
    static int[] arr;
    static int idx = 0;

    public static void main(String[] args) throws Exception {
        N = read();
        arr = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            int val = read();
            int u = upper(val);
            max = Math.max(max, u + 1);
            if (u == idx) {
                arr[idx++] = val;
            } else {
                arr[u] = val;
            }
        }
        System.out.println(max);
    }

    private static int upper(int k) {
        int l = 0;
        int r = idx;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (arr[mid] <= k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return r;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return n;
    }
}