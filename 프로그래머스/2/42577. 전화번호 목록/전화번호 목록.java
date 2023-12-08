import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            int length = Math.min(phone_book[i].length(), phone_book[i + 1].length());
            
            if (phone_book[i].startsWith(phone_book[i + 1].substring(0, length))) {
                return false;
            }
        }
        
        return true;
    }
}