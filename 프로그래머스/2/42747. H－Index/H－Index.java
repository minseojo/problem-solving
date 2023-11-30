class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        int answer = 0;
        for (int i = 1; i <= 1000; i++) {
            int h = 0;
            int rh = 0;
            for (int j : citations) {
                if (j >= i) {
                    h++;
                } 
                if (j <= i) {
                    rh++;
                }
            }

            if (h >= i && rh <= h) {
                answer = i;
            }
        }
        
        return answer;
    }
}