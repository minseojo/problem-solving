class Solution {
    int answer = 0;
    boolean check = false;
    public int solution(String word) {
        char[] type = {'A', 'E', 'I', 'O', 'U'};
        dfs(0, word, "", type);
        return answer - 1;
    }
    
    boolean dfs(int pos, String word, String cur, char[] type) {
        answer++;
                
        if (cur.equals(word)) {
            return true;
        }
        
        if (cur.length() >= 5) return false;


        
        for (int i = 0; i < 5; i++) {
            check = dfs(pos + 1, word, cur + type[i], type);
            if (check) return true;
        }
        
        return false;
    }
}