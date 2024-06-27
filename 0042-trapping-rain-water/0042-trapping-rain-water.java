class Solution {
    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int volume = 0;

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peekLast()]) {
                Integer top = stack.pollLast();

                if (stack.isEmpty()) break;

                int distance = i - stack.peekLast() - 1;
                int waters = Math.min(height[i], height[stack.peekLast()]) - height[top];
                volume += (distance * waters);
            }

            stack.addLast(i);
        }

        return volume;
    }
}
