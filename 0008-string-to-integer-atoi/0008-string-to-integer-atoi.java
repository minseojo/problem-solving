class Solution {
    public int myAtoi(String s) {
        if (s.isBlank()) return 0;

        s = s.trim();

        int ans = 0, i = 0;

        boolean neg = s.charAt(0) == '-';
        boolean pos = s.charAt(0) == '+';

        if (pos || neg) {
            i++;
        }

        if (!neg) pos = true;

        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10) && digit > Integer.MAX_VALUE % 10) {
                return pos ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } 
            
            ans = (ans * 10 + digit);
            i++;
        }

        return pos ? ans : -ans;
    }
}