class Solution {
    public int singleNonDuplicate(int[] nums) {
        int result=-1;
        int l=0, r=nums.length-1, m=-1;
        
        while(l<=r && r<nums.length) {
            m = l +(r-l)/2;
            if(m+1 >= nums.length) {
                result = nums[m];
                break;
            }
            if(m-1 <= -1) {
                result = nums[0];
                break;
            }

            if(nums[m] == nums[m-1]) {
                if(m%2 == 0) {
                    r = m-1;
                } else {
                    l = m+1;
                } 
            } else if(nums[m] == nums[m+1]) {
                if(m%2 == 0) {
                    l = m+1;
                } else {
                    r = m-1;
                }
            } else {
                result = nums[m];
                break;
            }
        }

        return result;
    }
}
// l은 짝수로 시작
// r은 항상 홀수, 짝수+1