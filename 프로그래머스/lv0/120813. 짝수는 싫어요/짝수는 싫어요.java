class Solution {
    public int[] solution(int n) {
        int[] answer;
        if (n%2 == 0) answer = new int[n/2];
        else answer = new int[n/2 + 1];

        int pos = 0;
        for(int i=1; i<=n; i+=2) {
            answer[pos++] = i;
        }
        return answer;
    }
}