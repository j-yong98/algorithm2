import java.util.*;
class Solution {
    final String EMPTY = "EMPTY";
    final int ROW = 50;
    final int COL = 50;
    final int MAX = ROW * COL;
    int[] m = new int[MAX];
    Map<Integer, String> words = new TreeMap<>();

    public String[] solution(String[] commands) {
        for (int i = 0; i < MAX; i++) {
            m[i] = i;
        }
        for (int i = 0; i < MAX; i++) {
            words.put(i, EMPTY);
        }
        List<String> answer = new ArrayList<>();
        for (String command : commands) {
            String[] split = command.split(" ");
            if (split[0].equals("UPDATE")) {
                if (split.length == 4) {
                    update1(Integer.parseInt(split[1]) - 1, Integer.parseInt(split[2]) - 1, split[3]);
                } else {
                    update2(split[1], split[2]);
                }
            } else if (split[0].equals("MERGE")) {
                merge(Integer.parseInt(split[1]) - 1, Integer.parseInt(split[2]) - 1, Integer.parseInt(split[3]) - 1,
                        Integer.parseInt(split[4]) - 1);
            } else if (split[0].equals("UNMERGE")) {
                unmerge(Integer.parseInt(split[1]) - 1, Integer.parseInt(split[2]) - 1);
            } else {
                answer.add(print(Integer.parseInt(split[1]) - 1, Integer.parseInt(split[2]) - 1));
            }
            // printTable();
        }
        return answer.toArray(new String[0]);
    }

    private void printTable() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                int a = i * ROW + j;
                int p = findParent(a);
                System.out.print(words.get(p).equals("EMPTY") ? "0 " : words.get(p) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void update1(int r, int c, String value) {
        int a = r * ROW + c;
        int p1 = findParent(a);
        words.put(p1, value);
    }

    private void update2(String value1, String value2) {
        for (int i = 0; i < MAX; i++) {
            int p = findParent(i);
            if (p != i) continue;
            String tmp = words.get(i);
            if (tmp.equals(value1)) {
                words.put(i, value2);
            }
        }
    }

    private void merge(int r1, int c1, int r2, int c2) {
        int a = r1 * ROW + c1;
        int b = r2 * ROW + c2;
        int p1 = findParent(a);
        int p2 = findParent(b);

        if (p1 == p2) {
            return;
        }
        String tmp = words.get(p1).equals(EMPTY) ? words.get(p2) : words.get(p1);
        words.put(p1, EMPTY);
        words.put(p2, EMPTY);
        words.put(p1, tmp);
        union(a, b);
    }

    private void unmerge(int r, int c) {
        int a = r * ROW + c;
        int p = findParent(a);
        String word = words.get(p);
        List<Integer> delete = new ArrayList<>();
        for (int i = 0; i < MAX; i++) {
            if (findParent(i) == p) {
                words.put(i, EMPTY);
                delete.add(i);
            }
        }
        for (Integer d : delete) {
            m[d] = d;
        }
        words.put(a, word);
    }

    private String print(int r, int c) {
        int a = r * ROW + c;
        int p = findParent(a);
        return words.get(p);
    }

    private void union(int a, int b) {
        int p1 = findParent(a);
        int p2 = findParent(b);

        if (p1 != p2) {
            m[p2] = p1;
        }
    }

    private int findParent(int a) {
        if (m[a] == a) {
            return a;
        }
        return m[a] = findParent(m[a]);
    }
}