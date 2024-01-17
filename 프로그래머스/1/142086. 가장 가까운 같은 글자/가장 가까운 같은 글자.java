class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] index = new int[26];
        for (int i = 0; i < 26; i++) {
            index[i] = -1;
        }
        
        int pos = 0;
        for (char c : s.toCharArray()) {
            int i = c - 'a';
            if (index[i] == -1) {
                answer[pos] = -1;
            } else {
                answer[pos] = pos - index[i];
            }
            index[i] = pos++;
        }
        
        return answer;
    }
}