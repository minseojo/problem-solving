class Solution {
    
    public boolean isPalindrome(String s) {
        String s_filterd = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String s_reversed = new StringBuilder(s_filterd).reverse().toString();
        return s_filterd.equals(s_reversed);
    }
    
//     public boolean isPalindrome(String s) {
//         int start = 0;
//         int end = s.length() - 1;
        
//         while (start < end) {
//             if (!Character.isLetterOrDigit(s.charAt(start))) {
//                 start++;
//             } else if(!Character.isLetterOrDigit(s.charAt(end))) {
//                 end--;
//             } else {
//                 if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
//                     return false;
//                 }
                
//                 start++;
//                 end--;
//             }
//         }
        
//         return true;
//     }
}