class Solution {
    public int maxSubArray(int[] nums) {
        int answer = Integer.MIN_VALUE;

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            answer = Math.max(answer, sum);
            if (sum < 0) sum = 0;
        }

        return answer;
    }
}