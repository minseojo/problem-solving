class Solution {
    
    int pos;
    boolean end;
    static char[] dict = new char[] {'A', 'E', 'I', 'O', 'U'};
    
    public int solution(String word) {
        int result = 0;
        dfs(word, new StringBuilder(""));
        return pos;
    }
    
    void dfs(String word, StringBuilder cur) {
        if (cur.length() > 5 || end) {
            return;
        }

        if (cur.toString().equals(word)) {
            end = true;
            return;
        }
        pos++;
        for (char d : dict) {
            cur.append(d);
            dfs(word, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}