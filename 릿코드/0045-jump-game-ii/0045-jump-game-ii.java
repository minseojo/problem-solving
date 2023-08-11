class Solution {
    public int jump(int[] nums) {     
        if(nums.length <= 1) return 0;
        int[] result = new int[nums.length];
        for(int i=0; i<nums.length; i++) result[i] = 987654321;
        
        for(int i=0; i<nums.length; i++) {
            for(int j=1; j<=nums[i]; j++) {
                if(i+j < nums.length) {
                    result[i+j] = Math.min(result[i+j], result[i]+1);
                    result[i+j] = Math.min(result[i+j], i+1);
                }
            }
        }
        for(int i=0; i<nums.length; i++) System.out.print(result[i]);
        return result[nums.length-1];
    }
}