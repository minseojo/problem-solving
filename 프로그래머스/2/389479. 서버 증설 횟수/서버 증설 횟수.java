class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int active = 0;
        int[] install = new int[24];
        
        for (int i = 0; i < 24; i++) {
            if (i >= k) {
                active -= install[i - k];
            }
            
            int request = players[i] / m;
            if (active < request) {
                int add = request - active;
                active += add;
                answer += add;
                install[i] = add;
            }
            
        }
        
        return answer;
    }
}