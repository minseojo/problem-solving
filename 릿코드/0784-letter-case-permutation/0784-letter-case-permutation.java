class Solution {
    ArrayList<String> result = new ArrayList<String>();
    public List<String> letterCasePermutation(String s) {
        s = s.toLowerCase();
        
        dfs(s, 0, new char[s.length()], 0);
        
        return result;
    }
    
    public void dfs(String s, int pos, char[] cache, int index) {
        if(pos == s.length()) {
            String str =  "";

            for(int i=0; i<s.length(); i++) {
                str += cache[i];
            }

            result.add(str);
            return;
        }
        
        for(int i=index; i<s.length(); i++) {
            if(!('0' <= s.charAt(i) && s.charAt(i) <= '9')) {
                cache[pos] = s.charAt(i);
                dfs(s, pos+1, cache, i+1);
                cache[pos] = (char) (s.charAt(i)-32);
                dfs(s, pos+1, cache, i+1);
            }
            else {
                cache[pos] = s.charAt(i);
                dfs(s, pos+1, cache, i+1);
            }
        }
    }
}

