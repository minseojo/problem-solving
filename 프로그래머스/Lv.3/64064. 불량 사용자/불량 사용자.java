import java.util.*;

class Solution {
    Set<Set<String>> answer = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        boolean[] userCheck = new boolean[user_id.length];
        Set<String> s = new HashSet<>();
        dfs(0, user_id, banned_id, userCheck, 0, s);
        return answer.size();
    }
    
    private void dfs(int pos, String[] user_id, String[] banned_id, boolean[] userCheck, int banIdx, Set<String> s) {
        if (pos == banned_id.length) {
            answer.add(new HashSet(s)); // 깊은 복사 적용 
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (!userCheck[i] && matchBanId(user_id[i], banned_id[banIdx])) {
                userCheck[i] = true;
                s.add(user_id[i]);
                dfs(pos + 1, user_id, banned_id, userCheck, banIdx + 1, s);
                s.remove(user_id[i]);
                userCheck[i] = false;
            }
        }
    }
    
    private boolean matchBanId(String userId, String banId) {
        if (userId.length() != banId.length()) {
            return false;
        }
        
        for (int i = 0; i < userId.length(); i++) {
            if (banId.charAt(i) == '*') {
                continue;
            }
            
            if (userId.charAt(i) != banId.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }
}