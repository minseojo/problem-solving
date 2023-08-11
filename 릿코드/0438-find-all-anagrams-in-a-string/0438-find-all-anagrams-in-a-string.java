class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new  ArrayList<Integer>();

        if(p.length() > s.length()) return result;
        int[] alpha = new int[26];
        for(int i=0; i<p.length(); i++) {
            alpha[p.charAt(i)-'a']++;
        }

        for(int i=0; i<s.length(); i++) {
            alpha[s.charAt(i)-'a']--;
            if(i-p.length() >= 0) alpha[s.charAt(i-p.length())-'a']++;
            if(totalZero(alpha)) result.add(i-p.length()+1);
        }

        return result;
    }
    
    public boolean totalZero(int[] alpha) {
        for(int i=0; i<26; i++) {
            if(alpha[i] != 0) return false; 
        }
        return true;
    }
}