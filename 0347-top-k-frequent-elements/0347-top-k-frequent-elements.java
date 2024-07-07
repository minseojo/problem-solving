class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();

        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        List<Integer> counterKetSet = new ArrayList<>(counter.keySet());
        counterKetSet.sort((o1, o2) -> Integer.compare(counter.get(o2), counter.get(o1)));

        int[] answer = new int[k];
        for (int i = 0; i < k; i++) {
            answer[i] = counterKetSet.get(i);
        }
        return answer;
    }
}