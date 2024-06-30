class Solution {
    public int maxArea(int[] height) {
        int answer = 0;

        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            int distance = right - left;
            answer = Math.max(answer, minHeight * distance); 

            if (height[left] >= height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return answer;
    }
}