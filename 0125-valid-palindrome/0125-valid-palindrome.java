class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z' || 
                s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                temp.append(s.charAt(i));
            }
        }

        int n = temp.length();
        if (n == 0 || n == 1) {
            return true;
        }
        
        for (int i = 0; i < n / 2; i++) {
            if (temp.charAt(i) != temp.charAt(n - i - 1)) {
                return false;
            }
        }
        
        return true;
    }
}