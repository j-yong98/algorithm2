import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    /**
     * FizzBuzz
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
        for (int i = 0; i < 3; i++) {
            String str = br.readLine();
            boolean flag = true;
            for (int j = 0; j < str.length(); j++) {
                if (!Character.isDigit(str.charAt(j))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                num = Integer.parseInt(str);
            }
            num++;
        }
        if (num % 3 == 0 && num % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (num % 3 == 0) {
            System.out.println("Fizz");
        } else if (num % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(num);
        }
        br.close();
    }
}