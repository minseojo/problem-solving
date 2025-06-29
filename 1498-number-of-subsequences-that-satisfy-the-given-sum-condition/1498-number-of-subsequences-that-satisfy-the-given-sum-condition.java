class Solution {
    public int numSubseq(int[] nums, int target) {
        int answer = 0;
        int n = nums.length;
        int mod = 1000000007;
        Arrays.sort(nums);

        int[] power = new int[n + 1];
        power[0] = 1;
        for (int i = 1; i < n; i++) {
            power[i] = (power[i - 1] * 2) % mod;
        }

        int l = 0, r = n -1;
        while (l <= r) {
            if (nums[l] + nums[r] <= target) {
                answer = (answer + power[r-l]) % mod;
                l++;
            } else {
                r--;   
            }
        }

        return answer;
    }
}