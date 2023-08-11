class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[n*2];
        int runner1 = 0, runner2 = n;
        int index = 0;
        for(int i=0; i<n; i++) {
            result[index++] = nums[runner1++];
            result[index++] = nums[runner2++];
        }
        return result;
    }
}