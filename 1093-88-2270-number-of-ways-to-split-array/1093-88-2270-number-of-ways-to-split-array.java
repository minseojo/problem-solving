class Solution {
    public int waysToSplitArray(int[] nums) {
        int result = 0;
        int len = nums.length;

        long sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }

        long l = 0;
        long r = sum;
        for (int m = 0; m < len - 1; m++) {
            l += nums[m];
            r -= nums[m];
            if (l >= r) result++;
        }

        return result;
    }
}