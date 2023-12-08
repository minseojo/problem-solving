import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            int length = Math.min(phone_book[i].length(), phone_book[i + 1].length());
            
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < length; j++) {
                sb.append(phone_book[i + 1].charAt(j));
            }

            if (phone_book[i].equals(sb.toString())) {
                return false;
            }
        }
        
        return true;
    }
}