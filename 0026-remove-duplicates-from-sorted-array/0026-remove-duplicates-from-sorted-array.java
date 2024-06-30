class Solution {
    public int removeDuplicates(int[] nums) {
        boolean[] isRemoved = new boolean[nums.length];

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                isRemoved[i] = true;
            }
        }

        int answer = 0;
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (!isRemoved[i]) {
                temp[answer++] = nums[i];
            }
        }

        for (int i = 0; i < answer; i++) {
            nums[i] = temp[i];
        }

        return answer;
    }
}