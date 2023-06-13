class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        for(int i=0; i<numLog.length-1; i++) {
            int dif = numLog[i+1] - numLog[i];
            if(dif == 1) answer += 'w';
            else if(dif == -1) answer += 's';
            else if(dif == 10) answer += 'd';
            else if(dif == -10) answer += 'a';
        }
        return answer;
    }
}