class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i, j) -> Integer.compare(j, i));
        for (int num : nums) {
            pq.add(num);
        }

        while (k-- > 1) {
            pq.poll();
        }

        return pq.peek();
    }
}