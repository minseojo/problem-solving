class Solution {
    public int[] solution(int n, int s) {
        if (n > s) {
            return new int[] {-1};
        }
        int[] answer = new int[n];
        
        int size = n;
        int sum = s;
        for (int i = 0; i < n; i++) {
            answer[i] = sum / size;
            sum -= (sum / size);
            size--;
        }
        
        return answer;
    }
}