class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int alpha[] = new int[26];

        for(int i=0; i<s1.length(); i++) {
            alpha[s1.charAt(i)-'a']++;
        }

        for(int i=0; i<s2.length(); i++) {
            alpha[s2.charAt(i)-'a']--;
            
            //Sliding Window
            if(i-s1.length() >= 0) {
                alpha[s2.charAt(i-s1.length())-'a']++;
            }

            if(totalZero(alpha)) return true;
        }

        return false;
    }

    boolean totalZero(int[] alpha) {
        for(int i=0; i<26; i++) {
            if(alpha[i] != 0) return false;
        }

        return true;
    }
}