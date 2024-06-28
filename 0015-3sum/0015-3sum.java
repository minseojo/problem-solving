class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue; // 중복 값 건너뛰기

            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];

                if (sum < 0) {
                    start++;
                } else if (sum > 0) {
                    end --;
                } else {
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[start], nums[end])));
                    start++;
                    end--;
                }
            }
        }

        return result.stream().toList();
    }
}