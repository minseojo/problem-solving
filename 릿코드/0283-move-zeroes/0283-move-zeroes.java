class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        int[] list = new int[nums.length];
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != 0) {
                list[index++] = nums[i];
            }
        }
        for(int i=index; i<nums.length; i++) list[i] = 0;
        
        for(int i=0; i<nums.length; i++) nums[i] = list[i];
    }
}