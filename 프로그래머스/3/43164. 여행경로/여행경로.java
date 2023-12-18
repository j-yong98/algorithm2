import java.util.*;
class Solution {
    int N;
    Map<String, List<Trip>> map = new HashMap<>();
    List<String> path = new ArrayList<>();
    List<String> answer = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        for (String[] ticket : tickets) {
            if (!map.containsKey(ticket[0])) {
                map.put(ticket[0], new ArrayList<>());
            }
            map.get(ticket[0]).add(new Trip(ticket[1]));
            N++;
        }
        for (List<Trip> t : map.values()) {
            Collections.sort(t, (a, b) -> a.destination.compareTo(b.destination));
        }
        dfs("ICN", 0);
        return answer.toArray(String[]::new);
    }
    
    private void dfs(String from, int cnt) {
        if (!answer.isEmpty()) return;
        if (cnt == N) {
            answer.add("ICN");
            for (String travel : path) {
                answer.add(travel);
            }
            return;
        }
        if (map.get(from) != null) {
            List<Trip> destination = map.get(from);
            for (Trip next : destination) {
                if (next.visited) continue;
                path.add(next.destination);
                next.visited = true;
                dfs(next.destination, cnt + 1);
                next.visited = false;
                path.remove(path.size() - 1);
            }
        }
    }
    
    static class Trip {
        String destination;
        boolean visited;
        
        public Trip(String destination) {
            this.destination = destination;
            this.visited = false;
        }
    }
}