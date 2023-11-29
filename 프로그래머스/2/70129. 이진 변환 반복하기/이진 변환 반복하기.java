class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int deletedZeroCount = 0;
        int convertCount = 0;

        while (!s.equals("1")) {
            answer[1] += s.length();
            s = deleteZero(s);

            answer[1] -= s.length();
            s = Integer.toBinaryString(s.length());
            answer[0]++;
        }
        
        return answer;
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
}