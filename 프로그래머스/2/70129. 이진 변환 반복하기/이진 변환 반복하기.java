
class Solution {
    public int[] solution(String s) {
        int deletedZeroCount = 0;
        int convertCount = 0;
        
        while (!s.equals("1")) {
            deletedZeroCount += countZero(s);
            s = deleteZero(s);
            int length = s.length();
            s = convertBainary(length);
            convertCount++;
        }
        
        return new int[] {convertCount, deletedZeroCount};
    }
    
    private int countZero(String s) {
        int result = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                result++;
            }
        }
        return result;
    }
    
    private String deleteZero(String s) {
        return s.replace("0", "");
    }
    
    private String convertBainary(int value) {
        StringBuilder result = new StringBuilder();
        while (value > 0) {
            result.append(value % 2);
            System.out.println(value + " " + value % 2);
            value /= 2;
        }
        
        return result.reverse().toString();
    }
}