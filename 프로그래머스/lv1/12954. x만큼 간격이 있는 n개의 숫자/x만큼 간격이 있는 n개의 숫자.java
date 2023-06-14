class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        int pos = 0; 
        long sum = 0;
        
        while(n > 0) {
            answer[pos++] = sum + (long) x;
            sum += x;
            n--;
        }
        return answer;
    }
}