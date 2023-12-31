class Solution {
    public String solution(String[] seoul) {
        int idx = 0;
        for (String s : seoul) {
            if (s.equals("Kim")) {
                return "김서방은 " + idx +"에 있다"; 
            }
            idx++;
        }
        return "";
    }
}