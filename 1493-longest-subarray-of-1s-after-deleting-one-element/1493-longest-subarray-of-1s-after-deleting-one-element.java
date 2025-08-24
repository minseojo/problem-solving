class Solution {
  public int longestSubarray(int[] nums) {
    int n = nums.length;
    int left = 0;
    int right = 0;
    int zeroIndex = -1;
    int zeroCount = 0;
    int answer = 0;
    int sum = Arrays.stream(nums)
        .sum();
    if (sum == 0) {
      return 0;
    }
    if (sum == nums.length) {
      return sum - 1;
    }
    if (nums[0] == 0) {
      zeroCount++;
      zeroIndex = 0;
    }
    //0이 최대 1개 포함되는 slide-window 사용
    while (right + 1 < n) {
      answer = Math.max(answer, countWindow(answer, left, right, zeroCount));
      if (nums[right + 1] == 1) {
        right++;
        continue;
      }
      if (nums[right + 1] == 0 && zeroCount == 0) {
        zeroIndex = right + 1;
        zeroCount++;
        right++;
        continue;
      }
      //이미 슬라이딩 윈도우에 0이 있는 경우, 먼저 들어온 0을 제외한다
      if (nums[right + 1] == 0 && zeroCount == 1) {
        //이전 0의 다음으로 left를 옮긴다
        left = zeroIndex + 1;
        zeroIndex = right + 1;
        right++;
      }
    }
    return Math.max(answer, countWindow(answer, left, right, zeroCount));
  }
  private int countWindow(int answer, int left, int right, int zeroCount) {
    int windowLength = Math.max(answer, right - left + 1);
    return zeroCount == 0 ? windowLength : windowLength - 1;
  }
}