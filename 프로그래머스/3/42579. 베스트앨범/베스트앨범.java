import java.util.*;
class Solution {
    int N;
    Map<String, Genre> map = new HashMap<>();
    public int[] solution(String[] genres, int[] plays) {
        N = genres.length;
        for (int i = 0; i < N; i++) {
            if (!map.containsKey(genres[i])) {
                map.put(genres[i], new Genre());
            }
            Genre g = map.get(genres[i]);
            g.count += plays[i];
            g.pq.add(new Song(i, plays[i]));
        }
        
        List<Map.Entry<String, Genre>> entryList = new ArrayList<>(map.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, Genre>>() {
            @Override
            public int compare(Map.Entry<String, Genre> o1, Map.Entry<String, Genre> o2) {
                return -Long.compare(o1.getValue().count, o2.getValue().count);
            }
        });
        
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < entryList.size(); i++) {
            Genre g = entryList.get(i).getValue();
            for (int j = 0; j < 2; j++) {
                if (g.pq.isEmpty()) break;
                answer.add(g.pq.poll().num);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    static class Genre {
        long count;
        PriorityQueue<Song> pq = new PriorityQueue<>((a, b) -> a.plays == b.plays ? Integer.compare(a.num, b.num) : Integer.compare(b.plays, a.plays));
    }
    
    static class Song {
        int num;
        int plays;
        
        public Song(int num, int plays) {
            this.num = num;
            this.plays = plays;
        }
    }
}