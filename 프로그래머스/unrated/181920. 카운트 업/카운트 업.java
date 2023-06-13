class Solution {
    public int[] solution(int start, int end) {
        int[] answer = new int[end-start+1];
        int pos=0;
        for(int i=start; i<=end; i++) {
            answer[pos++] = i;
        }
        return answer;
    }
}