class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums[0] > target) return 0;
        if(nums[nums.length-1] < target) return nums.length;
        int result = -1;
        int l=0, r=nums.length-1, m=-1;
        while(l<=r) {
            m =  l + (r-l)/2;
            if(nums[m] >= target) {
                result = m;
                r = m-1;
            } else {
                l = m+1;
            }
        }

        return result;
    }
}