class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        
        return true;
    }
}