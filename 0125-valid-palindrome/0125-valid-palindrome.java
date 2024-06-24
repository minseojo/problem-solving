class Solution {
    public boolean isPalindrome(String s) {

        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                temp.append(Character.toLowerCase(c));
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