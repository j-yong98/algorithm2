import java.util.*;
class Solution {
    int N;
    int M;
    StringBuilder sb = new StringBuilder();
    Map<String, Integer> isFind = new HashMap<>();
    List<String>[] find;
    boolean[] checked;
    Trie root = new Trie();
    Set<String> ans = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        N = user_id.length;
        M = banned_id.length;
        for (int i = 0; i < N; i++) {
            isFind.put(user_id[i], i);
            insert(user_id[i]);
        }
        find = new List[M];
        for (int i = 0; i < M; i++)
            find[i] = new ArrayList<>();
        
        for (int i = 0; i < M; i++)
            search(root, banned_id[i], 0, i);
        
        checked = new boolean[N];
        dfs(0);
        return ans.size();
    }
    
    private void dfs(int l) {
        if (l == M) {
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < N; i++) {
                if (!checked[i]) continue;
                tmp.append(i);
            }
            ans.add(tmp.toString());
            return;
        }
        for (String name : find[l]) {
            int idx = isFind.get(name);
            if (checked[idx]) continue;
            checked[idx] = true;
            dfs(l + 1);
            checked[idx] = false;
        }
    }
    private void insert(String str) {
        Trie cur = root;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (!cur.child.containsKey(c))
                cur.child.put(c, new Trie());
            cur = cur.child.get(c);
        }
        cur.isLast = true;
    }
    
    private void search(Trie cur, String str, int len, int idx) {
        if (len == str.length()) {
            if (cur.isLast)
                find[idx].add(sb.toString());
            return;
        }
        int res = 0;
        char c = str.charAt(len);
        if (c == '*') {
            for (char child : cur.child.keySet()) {
                sb.append(child);
                search(cur.child.get(child), str, len + 1, idx);
                sb.deleteCharAt(sb.length() - 1);
            }
        } else {
            if (!cur.child.containsKey(c)) return;
            sb.append(c);
            search(cur.child.get(c), str, len + 1, idx);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    static class Trie {
        Map<Character, Trie> child;
        boolean isLast;
        
        public Trie() {
            child = new HashMap<>();
        }
    }
}