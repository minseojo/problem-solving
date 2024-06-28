class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];

        int multi = 1;
        for (int i = 0; i < nums.length; i++) {
            multi = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                multi *= nums[j];
            }
            answer[i] = multi;
        }

        return answer;
    }
}