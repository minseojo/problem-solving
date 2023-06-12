class Solution {
    public String solution(String str1, String str2) {
        String answer = "";

        int length = str1.length(); 
        String[] str1arr = str1.split("");
        String[] str2arr = str2.split("");
        for (int i=0; i<length; i++) {
            answer += str1arr[i]+str2arr[i];
        }

        return answer;
    }
}
/*class Solution {
    public String solution(String str1, String str2) {
        String answer = "";
        int[] pos = new int[3];
        pos[1] = 0;
        pos[2] = 0;
        while(pos[1] < str1.length() && pos[2] <str2.length()) {
            if(pos[1] < str1.length()) {
                answer += str1.charAt(pos[1]);
                pos[1]++;
            }
            if(pos[2] < str2.length()) {
                answer += str2.charAt(pos[2]);
                pos[2]++;
            }
        }
        return answer;
    }
}
*/