class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a[0], b[0]);
        });

        for (int i = len - 1; i >= 0; i--) {
            if (pq.size() < k) {
                pq.add(new int[] {nums[i], i});
            } else {
                if (pq.peek()[0] < nums[i]) {
                    pq.poll();
                    pq.add(new int[] {nums[i], i});
                }
            }
        }

        List<int[]> temp = new ArrayList<>();
        while (!pq.isEmpty()) {
           temp.add(pq.poll());
        }
        temp.sort((a, b) -> {
            return Integer.compare(a[1], b[1]);
        });

        return temp.stream().mapToInt(arr -> arr[0]).toArray();
    }
}