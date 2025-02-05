import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    /**
     * 생일
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Student> list = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            list.add(new Student(name, month, day, year));
        }
        list.sort((a, b) -> a.year == b.year ? a.month == b.month ? Integer.compare(a.day, b.day) : Integer.compare(a.month, b.month) : Integer.compare(a.year, b.year));
        System.out.println(list.get(list.size() - 1).name);
        System.out.println(list.get(0).name);
        br.close();
    }

    static class Student {
        String name;
        int month;
        int day;
        int year;

        public Student(String name, int month, int day, int year) {
            this.name = name;
            this.month = month;
            this.day = day;
            this.year = year;
        }
    }
}