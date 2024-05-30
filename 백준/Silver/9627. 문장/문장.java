import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static int N;
    static String[] arr;
    static Map<Integer, String> number = new HashMap<>();

    /**
     * 문장
     */
    public static void main(String[] args) throws IOException {
        init();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new String[N];
        int len = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
            if (arr[i].equals("$")) {
                continue;
            }
            len += arr[i].length();
        }
        String ans = "";
        for (int i = 1; i < 1000; i++) {
            String temp = toWord(i);
            if (len + temp.length() == i) {
                ans = temp;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            if (s.equals("$")) {
                sb.append(ans).append(" ");
            } else {
                sb.append(s).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
        br.close();
    }

    private static String toWord(int num) {
        if (num < 20) {
            return number.get(num);
        }

        StringBuilder sb = new StringBuilder();
        while (num > 9) {
            if (number.containsKey(num)) {
                sb.append(number.get(num));
                num = 0;
                break;
            }
            int len = length(num);
            int p = (int) Math.pow(10, len - 1);

            int r = (num / p) * p;
            if (number.containsKey(r)) {
                sb.append(number.get(r));
            } else {
                sb.append(number.get(num / p)).append("hundred");
            }

            num %= p;
        }
        if (number.containsKey(num)) {
            sb.append(number.get(num));
        }
        return sb.toString();
    }

    private static int length(int num) {
        int len = 0;
        while (num > 0) {
            num /= 10;
            len++;
        }
        return len;
    }

    private static void init() {
        number.put(1, "one");
        number.put(2, "two");
        number.put(3, "three");
        number.put(4, "four");
        number.put(5, "five");
        number.put(6, "six");
        number.put(7, "seven");
        number.put(8, "eight");
        number.put(9, "nine");
        number.put(10, "ten");
        number.put(11, "eleven");
        number.put(12, "twelve");
        number.put(13, "thirteen");
        number.put(14, "fourteen");
        number.put(15, "fifteen");
        number.put(16, "sixteen");
        number.put(17, "seventeen");
        number.put(18, "eighteen");
        number.put(19, "nineteen");
        number.put(20, "twenty");
        number.put(30, "thirty");
        number.put(40, "forty");
        number.put(50, "fifty");
        number.put(60, "sixty");
        number.put(70, "seventy");
        number.put(80, "eighty");
        number.put(90, "ninety");
    }
}