class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        answer[1] = Integer.MAX_VALUE - 1;
        int[] prefixSum = new int[sequence.length];
        prefixSum[0] = sequence[0];
        for (int i = 1; i < sequence.length; i++) {
            prefixSum[i] = sequence[i] + prefixSum[i-1];
        }
        
        int l = -1;
        int r = 0;
        while (l <= r && r < prefixSum.length) {
            int sum = 0;
            if (l == -1) sum = prefixSum[r];
            else sum = prefixSum[r] - prefixSum[l];
            
            if (sum == k) {
                if (r - l < (answer[1] + 1) - answer[0]) {
                    answer[0] = l + 1;
                    answer[1] = r;
                }
                l++;
            } else if (sum > k) {
                l++;
            } else if (sum < k) {
                r++;
            }
        }
        
        return answer;
    }
}